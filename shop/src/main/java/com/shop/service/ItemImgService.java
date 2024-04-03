package com.shop.service;

import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shop.entity.ItemImg;
import com.shop.repository.ItemImgRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemImgService {
   
	@Value("${itemImgLocation}") //1. @Value를 이용하여 application.properties 파일에 등록한 itemImgLocation값을 불러와서 itemImgLocation 변수에 넣어 줍니다.
	private String itemImgLocation;
	
	private final ItemImgRepository itemImgRepository;
	
	private final FileService fileService;
	
	public void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws Exception{
		String oriImgName = itemImgFile.getOriginalFilename();
		String imgName="";
		String imgUrl="";
		
		//파일 업로드
		if(!StringUtils.isEmpty(oriImgName)) {
			imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes()); 
			//2. 사용자가 상품의 이미지를 등록했다면 저장할 경로와 파일의 이름, 파일을 파일의바이트 배열을 파일 업로드 파리미터로 uploadFile메소드를 호출합니다.
			// 호출결과로 로컬에 저장한 파일의 이름을 imgName에 저장함
			imgUrl = "/images/item/" + imgName; 
			//3. 저장한 상품 이미지를 불러올 경로를 설정합니다. 외부 라소스를 불러오는 urlPatterns로 WebMvcConfig 클래스에서 /images/**을 설정해 주었습니다.
			//또한 application.properties에서 설정한 uploadPath 프로퍼티경로인 "D:/2023/spring_study/shop/"아래에 item폴더에 이미지를 저장하므로
			//상품이미지를 불러오는 경로로 "/images/item"를 붙여 줍니다.
			
		}
		//상품 이미지 정보 저장
		itemImg.updateItemImg(oriImgName, imgName, imgUrl); //4. 입력받은 상품 이미지 정보를 저장합니다
		// imgName - 실제 로컬에 저장된 상품 이미지 파일의 이름
		// orimgName - 업로드했던 상품 이미지 파일의 원래 이림
		// imgUrl - 업로드 결과 로컬에 저장된 상품 이미지 파일을 불러오는 경로
		itemImgRepository.save(itemImg);
	}

	public void updateItemImg(Long itemImgId, MultipartFile itemImgFile) throws Exception {
		if(!itemImgFile.isEmpty()) {
			ItemImg savedItemImg = itemImgRepository.findById(itemImgId).orElseThrow(EntityNotFoundException::new);
			if(StringUtils.isEmpty(savedItemImg.getImgName())) {
				fileService.deleteFile(itemImgLocation + "/" + savedItemImg.getOriImgName());
			}
		}
		
	}
	
	
}
