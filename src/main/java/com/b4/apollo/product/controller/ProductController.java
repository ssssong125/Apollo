package com.b4.apollo.product.controller;

import com.b4.apollo.product.model.dto.ProdAndImageDTO;
import com.b4.apollo.product.model.dto.ProductImageDTO;
import com.b4.apollo.product.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("list")
    public ModelAndView productList(ModelAndView mv) {

        List<ProdAndImageDTO> productList = productService.productList();
        productList.stream().forEach(product -> System.out.println("product = " + product));

        mv.addObject("productList", productList);
        mv.setViewName("product/list");
        return mv;
    }
    @GetMapping("list/{category}")
    public ModelAndView productListByCode(ModelAndView mv, @PathVariable("category") String category) {

        System.out.println("_+++++++++++++++++++++++++++++++++++++++++++++++++++++++=");
//        List<ProdAndImageDTO> productList = productService.productList(category);
        List<ProdAndImageDTO> productList = productService.productListByCode();
        productList.stream().forEach(product -> System.out.println("product = " + product));

        mv.addObject("productList", productList);
        mv.setViewName("product/list");

        return mv;
    }

    @GetMapping("detail/{code}")/*  int code 에 대한 것을 {}로 써야함 ???  */
    public ModelAndView productDetail(ModelAndView mv, @PathVariable("code") int code) {
        ProdAndImageDTO productDetail = productService.productDetail(code);
        mv.addObject("productDetail", productDetail);
        mv.setViewName("product/detail");
        return mv;
    }
    @GetMapping("regist")
    public void registPage(){

    }
        @PostMapping("regist")
   // public ModelAndView registProduct(ModelAndView mv, ProdAndImageDTO newProd, ProductImageDTO imgdto, RedirectAttributes rttr) /*throws Exception*/ {
            public ModelAndView registProduct(ModelAndView mv, ProdAndImageDTO newProd/*, ProductImageDTO imgdto, @AuthenticationPrincipal PrincipalDetails principalDetails*/, MultipartFile[] imgFile) throws Exception {
                //   if(principalDetails.getUser().getRole().equals("ROLE_ADMIN") || principalDetails.getUser().getRole().equals("ROLE_SELLER")) {
        //    String originName[] = new String[imgFile.length];
          //  String savedName[] = new String[imgFile.length];
         //   String projectPath[] = new String[imgFile.length];
        //    String originName = null;
         //   String savedName = null;
       //     String projectPath = null;

            List<ProductImageDTO> imgList = new ArrayList<>();

            for(int i =0 ; i<imgFile.length ; i++) {
                ProductImageDTO imgdto = new ProductImageDTO();
              //  originName[i] = imgFile[i].getOriginalFilename();
                String originName = imgFile[i].getOriginalFilename();
//                projectPath[i] = System.getProperty("user.dir") + "/src/main/resources/static/img/product/";

                String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/img/product/";
                // UUID 를 이용하여 파일명 새로 생성
                // UUID - 서로 다른 객체들을 구별하기 위한 클래스
                UUID uuid = UUID.randomUUID();

//                savedName[i] = uuid + "_" + originName[i]; //
                String savedName = uuid + "_" + originName;


//                File saveFile = new File(projectPath[i], savedName[i]);
                File saveFile = new File(projectPath, savedName);
                imgFile[i].transferTo(saveFile);

//                imgdto.setStoredName(savedName[i]);
//                imgdto.setOriginName(originName[i]);
                imgdto.setStoredName(savedName);
                imgdto.setOriginName(originName);
                if(i==0){

                    imgdto.setIsThumbnail("Y");
                }else{
                    imgdto.setIsThumbnail("N");
                }
//                imgdto.setImgPath("/img/product/" + savedName[i]);
                imgdto.setImgPath("/img/product/" + savedName);
                System.out.println("경로 : "+imgdto.getImgPath());
//                if(imgFile[i]!=null){
//                    imgList.add(imgdto);
//                    break;
//                }
                imgList.add(imgdto);
          //      imgList.set(i,imgdto);
                System.out.println(imgList);
            }

            newProd.setProductImageDTOList(imgList);
            System.out.println(newProd.getProductImageDTOList());
            productService.registProduct(newProd);
         //   String originName = imgFile.getOriginalFilename();


                // 판매자
                //  item.setSeller(principalDetails.getUser());
                //          productService.saveItem(item, imgFile);

                //      return "redirect:/main";
                //   } else {
                //    return "redirect:/main";
                //  }
     //       }


        mv.setViewName("redirect:/product/list");
    //    rttr.addFlashAttribute("successMessage","신규 메뉴 등록에 성공하셨습니다." );

        return mv;
    }
    @GetMapping("edit/{code}")
//    @GetMapping("edit")
    public String editPage(@PathVariable("code") int code){
        System.out.println("갯지렁이 겟 도달 여기까지는 도달");
        return "/product/edit";
    }
    @PostMapping("edit/{code}")
//    @PostMapping("edit")
    public ModelAndView editProduct(ModelAndView mv, ProdAndImageDTO newProd, MultipartFile[] imgFile, @PathVariable("code") int code/*, RedirectAttributes rttr*/) /*throws Exception*/ {
        System.out.println("post 여기까지 도달 ,,, ");


//
//        A.PRODUCT_NAME = #{ productName }
//          , A.PRODUCT_PRICE = #{  productPrice }
//          , A.PRODUCT_DESC = #{  productDesc }
//          , A.PRODUCT_QTY = #{  productQty }
//          , A.CATEGORY_CODE = #{  categoryCode }

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

//                imgdto.setStoredName(savedName[i]);
//                imgdto.setOriginName(originName[i]);
            imgdto2.setStoredName(savedName);
            imgdto2.setOriginName(originName);
            if(i==0){

                imgdto2.setIsThumbnail("Y");
            }else{
                imgdto2.setIsThumbnail("N");
            }
//                imgdto.setImgPath("/img/product/" + savedName[i]);
            imgdto2.setImgPath("/img/product/" + savedName);
            System.out.println("경로 : "+imgdto2.getImgPath());
//                if(imgFile[i]!=null){
//                    imgList.add(imgdto);
//                    break;
//                }
            imgList2.add(imgdto2);
            //      imgList.set(i,imgdto);
            System.out.println(imgList2);
            imgdto2.setProductNo(currProd.getProductNo());
            imgdto2.setFileNo(fileNo);
       //     imgdto2.set
            fileNo++;
        }

        newProd.setProductImageDTOList(imgList2);
        System.out.println( "번호 :  "+newProd.getProductImageDTOList());
//        HashMap<String, Object> parameter = new HashMap<>();
//        parameter.put("productName", newProd.getProductName());
//        parameter.put("productPrice", newProd.getProductPrice());
//        parameter.put("productDesc", newProd.getProductDesc());
//        parameter.put("productQty", newProd.getProductQty());
//        parameter.put("categoryCode", s);
        productService.editProduct(newProd);
//        mv.addObject("editProduct", editPage);
//        mv.setViewName( String.format("redirect:/product/detail/%s", code));
//        mv.addObject("b", boardService.selectBoard(bno))
//                .setViewName("board/boardUpdateForm");
        System.out.println(newProd.getProductNo());

//        mv.addObject("code", newProd.getProductNo())
//                .setViewName(String.format("redirect:/product/detail/%s", code));
        mv.addObject("edit", newProd);
                mv.setViewName(String.format("redirect:/product/detail/%s", code));
//        rttr.addFlashAttribute("successMessage","신규 메뉴 등록에 성공하셨습니다." );
        ProdAndImageDTO img = new ProdAndImageDTO();

        return mv;
    }
    @GetMapping("delete") /*  int code 에 대한 것을 {}로 써야함 ???  */
    public ModelAndView productDelete(ModelAndView mv, Integer code) {
        productService.productDelete(code);
//        mv.addObject("productDelete", productDelete);
        mv.setViewName("redirect:/product/list");
        return mv;
    }
}
