package com.b4.apollo.product.controller;

import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.service.CartService;
import com.b4.apollo.product.model.dao.ProductMapper;
import com.b4.apollo.product.model.dto.CategoryDTO;
import com.b4.apollo.product.model.dto.ProdAndImageDTO;
import com.b4.apollo.product.model.dto.ProductImageDTO;
import com.b4.apollo.product.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 @FileName : ProductController
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 박유리
 @프로그램 설명 : 상품에 관한 처리를 담당하는 클래스
 */
@Controller
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    private final ProductMapper productMapper;

    private final CartService cartService;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper, CartService cartService) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.cartService = cartService;
    }
    /**
     * @MethodName : productList
     * @작성일 : 2023. 01. 03.
     * @작성자 : 박유리
     * @Method 설명 : GetMapping방식으로 상품 전체 목록을 조회함
     */
    @GetMapping("list")
    public ModelAndView productList(ModelAndView mv) {

        List<ProdAndImageDTO> productList = productService.productList();
        productList.stream().forEach(product -> System.out.println("product = " + product));

        List<CategoryDTO> category = productMapper.readCategory();

        System.out.println("category = " + category);

        mv.addObject("productList", productList);
        mv.addObject("category", category);

        mv.setViewName("product/list");

        return mv;
    }

    /**
     * @MethodName : readProdListAjax
     * @작성일 : 2023. 01. 16.
     * @작성자 : 박유리
     * @Method 설명 : ajax를 이용한 악기 종류별 상품 목록 조회
     */
    @ResponseBody
    @PostMapping("/AjaxList")
    public ModelAndView readProdListAjax(ModelAndView mv, String categoryCode) {

        List<ProdAndImageDTO> categoryList = productService.productListByCode(categoryCode);
        System.out.println("categoryList = " + categoryList);
        mv.addObject("cateList", categoryList);
        return mv;
    }
    /**
     * @MethodName : productDetail
     * @작성일 : 2023. 01. 09.
     * @작성자 : 박유리
     * @Method 설명 : 상품 사진을 누르면 호출되는 메소드. 해당 상품의 상세 정보 조회
     */
    @GetMapping("detail/{code}")
    public ModelAndView productDetail(ModelAndView mv, @PathVariable("code") int code) {
        ProdAndImageDTO productDetail = productService.productDetail(code);
        mv.addObject("productDetail", productDetail);
        mv.setViewName("product/detail");
        return mv;
    }

    @GetMapping("regist")
    public void registPage(HttpSession session){
        String isAdmin = (String) session.getAttribute("userId");
        System.out.println("isAdmin = " + isAdmin);

        if(isAdmin=="admin"){

        }else{

        }
    }
    /**
     * @MethodName : registProduct
     * @작성일 : 2023. 01. 09.
     * @작성자 : 박유리
     * @Method 설명 : 새로운 상품을 등록하는 메소드. 상품 사진을 경로와 이름으로 저장
     */
    @PostMapping("regist")
    public ModelAndView registProduct(ModelAndView mv, ProdAndImageDTO newProd, MultipartFile[] imgFile) throws Exception {

            List<ProductImageDTO> imgList = new ArrayList<>();

            for(int i =0 ; i<imgFile.length ; i++) {

                ProductImageDTO imgdto = new ProductImageDTO();

                String originName = imgFile[i].getOriginalFilename();
                String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/img/product/";

                // UUID 를 이용하여 파일명 새로 생성
                // UUID - 서로 다른 객체들을 구별하기 위한 클래스
                UUID uuid = UUID.randomUUID();

                String savedName = uuid + "_" + originName;

                File saveFile = new File(projectPath, savedName);
                imgFile[i].transferTo(saveFile);

                imgdto.setStoredName(savedName);
                imgdto.setOriginName(originName);

                if(i==0){
                    imgdto.setIsThumbnail("Y");
                }else{
                    imgdto.setIsThumbnail("N");
                }

                imgdto.setImgPath("/img/product/" + savedName);
                System.out.println("경로 : "+imgdto.getImgPath());

                imgList.add(imgdto);

                System.out.println(imgList);
            }

            newProd.setProductImageDTOList(imgList);
            System.out.println(newProd.getProductImageDTOList());
            productService.registProduct(newProd);

        mv.setViewName("redirect:/product/list");

        return mv;
    }
    @GetMapping("edit/{code}")
    public String editPage(@PathVariable("code") int code){

        return "/product/edit";
    }
    /**
     * @MethodName : editProduct
     * @작성일 : 2023. 01. 12.
     * @작성자 : 박유리
     * @Method 설명 : 기존 등록된 상품의 정보를 수정하는 메소드.
     */
    @PostMapping("edit/{code}")
    public ModelAndView editProduct(ModelAndView mv, ProdAndImageDTO newProd, MultipartFile[] imgFile, @PathVariable("code") int code) /*throws Exception*/ {

        ProdAndImageDTO currProd = this.productService.productDetail(code);
        newProd.setProductNo(currProd.getProductNo());

        List<ProductImageDTO> imgList2 = new ArrayList<>();

        int fileNo = currProd.getProductImageDTOList().get(0).getFileNo();

        for(int i =0 ; i<imgFile.length ; i++) {
            ProductImageDTO imgdto2 = new ProductImageDTO();

            String originName = imgFile[i].getOriginalFilename();

            String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/img/product/";

            // UUID 를 이용하여 파일명 새로 생성
            // UUID - 서로 다른 객체들을 구별하기 위한 클래스
            UUID uuid = UUID.randomUUID();

            String savedName = uuid + "_" + originName;


            File saveFile = new File(projectPath, savedName);
            try {
                imgFile[i].transferTo(saveFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            imgdto2.setStoredName(savedName);
            imgdto2.setOriginName(originName);

            if(i==0){

                imgdto2.setIsThumbnail("Y");
            }else{
                imgdto2.setIsThumbnail("N");
            }

            imgdto2.setImgPath("/img/product/" + savedName);
            System.out.println("경로 : "+imgdto2.getImgPath());

            imgList2.add(imgdto2);

            System.out.println(imgList2);
            imgdto2.setProductNo(currProd.getProductNo());
            imgdto2.setFileNo(fileNo);

            fileNo++;
        }

        newProd.setProductImageDTOList(imgList2);
        System.out.println( "번호 :  "+newProd.getProductImageDTOList());

        productService.editProduct(newProd);

        System.out.println(newProd.getProductNo());

        mv.addObject("edit", newProd);
        mv.setViewName(String.format("redirect:/product/detail/%s", code));

        return mv;
    }
    @GetMapping("delete")
    public void deletePage(){

    }
    /**
     * @MethodName : productDelete
     * @작성일 : 2023. 01. 12.
     * @작성자 : 박유리
     * @Method 설명 : 기존 등록된 상품을 삭제하는 메소드.
     */
    @PostMapping("delete") /*  int code 에 대한 것을 {}로 써야함 ???  */
    public ModelAndView productDelete(ModelAndView mv, ProdAndImageDTO prod) {
        System.out.println(prod);
        prod = productService.productDetail(prod.getProductNo());
        productService.productDelete(prod);

        mv.setViewName("redirect:/product/list");
        return mv;
    }
    /**
     * @MethodName : headerBadge
     * @작성일 : 2023. 01. 17.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 현재 장바구니에 담긴 상품수를 헤더 카트 아이콘 옆에 뱃지로 표현
     */
    @GetMapping("/header")
    public void headerBadge(HttpSession session, Model model){

        String userId = (String) session.getAttribute("userId");

        if (userId != null){

            List<CartDTO> cartList = cartService.getCartList(userId);
            model.addAttribute("cartList", cartList);
        }
    }
}
