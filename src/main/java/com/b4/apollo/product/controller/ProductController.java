package com.b4.apollo.product.controller;

import com.b4.apollo.product.model.dto.ProdAndImageDTO;
import com.b4.apollo.product.model.dto.ProductImageDTO;
import com.b4.apollo.product.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
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

    @GetMapping("detail ")/*  int code 에 대한 것을 {}로 써야함 ???  */
    public ModelAndView productDetail(ModelAndView mv, int code) {
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
            public ModelAndView registProduct(ModelAndView mv, ProdAndImageDTO newProd, ProductImageDTO imgdto/*, @AuthenticationPrincipal PrincipalDetails principalDetails*/, MultipartFile[] imgFile) throws Exception {
                //   if(principalDetails.getUser().getRole().equals("ROLE_ADMIN") || principalDetails.getUser().getRole().equals("ROLE_SELLER")) {
            String originName[] = null;
            List<ProductImageDTO> imgList = new ArrayList<>();
            for(int i =0 ; i<imgFile.length ; i++) {
                originName[i] = imgFile[i].getOriginalFilename();
                String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/img/product/";
//
                // UUID 를 이용하여 파일명 새로 생성
                // UUID - 서로 다른 객체들을 구별하기 위한 클래스
                UUID uuid = UUID.randomUUID();

                String savedName = uuid + "_" + originName; //



                File saveFile = new File(projectPath, savedName);

                imgFile[i].transferTo(saveFile);

                imgdto.setStoredName(savedName);
                imgdto.setOriginName(originName[i]);
                if(i%3==0){
                    imgdto.setIsThumbnail("Y");
                }else{
                    imgdto.setIsThumbnail("N");
                }
                imgdto.setImgPath("/img/product/" + savedName);
                imgList.add(imgdto);
            }

         //   String originName = imgFile.getOriginalFilename();


                // 판매자
                //  item.setSeller(principalDetails.getUser());
                //          productService.saveItem(item, imgFile);

                //      return "redirect:/main";
                //   } else {
                //    return "redirect:/main";
                //  }
     //       }
            newProd.setProductImageDTOList(imgList);
        productService.registProduct(newProd);
        mv.setViewName("redirect:/product/list");
    //    rttr.addFlashAttribute("successMessage","신규 메뉴 등록에 성공하셨습니다." );

        return mv;
    }
    @GetMapping("edit")
    public void editPage(){

    }
    @PostMapping("edit")
    public ModelAndView editProduct(ModelAndView mv, ProdAndImageDTO newProd/*, RedirectAttributes rttr*/) /*throws Exception*/ {

        productService.editProduct(newProd);
        mv.setViewName("redirect:/product/list");
//        rttr.addFlashAttribute("successMessage","신규 메뉴 등록에 성공하셨습니다." );

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
