package com.b4.apollo.product.controller;

import com.b4.apollo.product.model.dto.ProductImageDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
//@RequestMapping("product")
public class ProductImageController {
    // 루트 경로 불러오기
    private static final String rootPath = System.getProperty("user.dir");
    // 프로젝트 루트 경로에 있는 files 디렉토리
    private static final String fileDir = rootPath + "/files/";
//    @Autowired
//    private final ProductImageDTO pid;
    public static String getFullPath(String filename) { return fileDir + filename; }

    public static ProductImageDTO storeFile(MultipartFile multipartFile) throws IOException {

        if(multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        // 작성자가 업로드한 파일명 -> 서버 내부에서 관리하는 파일명
        // 파일명을 중복되지 않게끔 UUID로 정하고 ".확장자"는 그대로
        String storeFilename = UUID.randomUUID() + "." + extractExt(originalFilename);

        // 파일을 저장하는 부분 -> 파일경로 + storeFilename 에 저장
        multipartFile.transferTo(new File(getFullPath(storeFilename)));
        ProductImageDTO imgdto = new ProductImageDTO();
        imgdto.setOriginName(originalFilename);
        imgdto.setStoredName(storeFilename);
        //여기서 다른 정보를 담던가 컬럼을 없애야할듯,..
//        imgdto.setProductNo();
        return imgdto;
    }

    // 파일이 여러개 들어왔을 때 처리해주는 부분
    public static List<ProductImageDTO> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<ProductImageDTO> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if(!multipartFile.isEmpty()) {
                storeFileResult.add(storeFile(multipartFile));
            }

        }
//        for(int i =0; i<3;i++){
//
//        }
     //   ProductImageDTO piDTO = new ProductImageDTO();
//        for(int i = 0 ; i<multipartFiles.size(); i++ ){
//            String originalFilename = multipartFiles.get(i).getOriginalFilename();
//            // 작성자가 업로드한 파일명 -> 서버 내부에서 관리하는 파일명
//            // 파일명을 중복되지 않게끔 UUID로 정하고 ".확장자"는 그대로
//            String storeFilename = UUID.randomUUID() + "." + extractExt(originalFilename);
//            // 파일을 저장하는 부분 -> 파일경로 + storeFilename 에 저장
//            multipartFiles.get(i).transferTo(new File(getFullPath(storeFilename)));

//        ProductImageDTO img = new ProductImageDTO();
//        img.setOriginName(newProd.getProductImageDTOList().get(i).getOriginName());
//        img.setStoredName(newProd.getProductImageDTOList().get(i).getStoredName());
//            String isThumb = "N";
//            if(i%3==0) isThumb="Y";
//            storeFileResult
//                    .add(new ProductImageDTO( i+1, originalFilename, storeFilename, isThumb, 1));
//        }



        return storeFileResult;
    }

    // 확장자 추출 나중에 없애기
    private static String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
}
