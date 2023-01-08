package com.b4.apollo.product.controller;

import com.b4.apollo.product.model.dto.ProdAndImageDTO;
import com.b4.apollo.product.model.dto.ProductDTO;
import com.b4.apollo.product.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        List<ProductDTO> productList = productService.productList();
        productList.stream().forEach(product -> System.out.println("product = " + product));

        mv.addObject("productList", productList);
        mv.setViewName("product/list");
        return mv;
    }

    @GetMapping("detail ")/*  int code 에 대한 것을 {}로 써야함 ???  */
    public ModelAndView productDetail(ModelAndView mv, int code) {
        ProductDTO productDetail = productService.productDetail(code);
        mv.addObject("productDetail", productDetail);
        mv.setViewName("product/detail");
        return mv;
    }
    @GetMapping("regist")
    public void registPage(){

    }
        @PostMapping("regist")
    public ModelAndView registProduct(ModelAndView mv, ProdAndImageDTO newProd, RedirectAttributes rttr) /*throws Exception*/ {
//            Content content = new Content();
//            () -> newProd.setProductImageDTOList
//            content.setWriter(form.getWriter());
//            content.setTexts(form.getTexts());

//            for(int i=0; i<3;i++){
//                ProductImageDTO img = new ProductImageDTO();
//                img.setOriginName(newProd.getProductImageDTOList().get(i).getOriginName());
//                img.setStoredName(newProd.getProductImageDTOList().get(i).getStoredName());
//            }
            /* 파일 정보 저장 */

//            attach.setOriginalName(file.getOriginalFilename());
//            attach.setStoredName(storedName);
//
//            /* 파일 정보 추가 */
//            attachList.add(attach);
//
//
//            LocalDateTime NowTime = LocalDateTime.now();
//            String formatDate = NowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            content.setUpdateDate(formatDate);
//
//            // 첨부파일, 이미지들 처리하는 부분
//            UploadFile attachFile = fileStore.storeFile(form.getAttachFile());
//            List<UploadFile> imageFiles = fileStore.storeFiles(form.getImageFiles());
//            content.setAttachFile(attachFile);
//            content.setImageFiles(imageFiles);
//
//            contentService.writeContent(content);
//
//
//
//            // 첨부파일, 이미지들 처리하는 부분
//            //ProductImageDTO attachFile = fileStore.storeFile(newProd.getAttachFile());
//            List<ProductImageDTO> imageFiles = ProductImageController.storeFiles(newProd.getProductImageDTOList());
//            //content.setAttachFile(attachFile);
//            for(int i =0 ; i<imageFiles.size();i++) {
//                newProd.getProductImageDTOList().get(i).setProductImageDTOList(imageFiles);
//            }
            List<MultipartFile> list = new ArrayList<>();
//            productService.registProduct(content);
            ProductImageController imgController = new ProductImageController();

            try {
                newProd.setProductImageDTOList(imgController.storeFiles(list));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


//            for (MultipartFile multipartFile : multipartFiles) {
//                if(!multipartFile.isEmpty()) {
//                    storeFileResult.add(storeFile(multipartFile));
//                }
//
//            }
        productService.registProduct(newProd);
        mv.setViewName("redirect:/product/list");
        rttr.addFlashAttribute("successMessage","신규 메뉴 등록에 성공하셨습니다." );

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
