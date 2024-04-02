package com.shop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;
import com.shop.entity.Item;
import com.shop.repository.ItemImgRepository;
import com.shop.repository.ItemRepository;

import jakarta.persistence.EntityNotFoundException;


@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application.properties")
public class ItemServiceTest {
	@Autowired
	ItemService itemService;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	ItemImgRepository itemImgRepository;
	
	List<MultipartFile> createMultipartFiles() throws Exception{
		List<MultipartFile> multipartFileList = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			String path = "C:/Users/tj/Downloads/ai/temp";
			String imageName = "image"+i+".jpg";
			MockMultipartFile multipartFile = new MockMultipartFile(path, imageName, "image/jpg", new byte[] {1,2,3,4});
			multipartFileList.add(multipartFile);
		}
		return multipartFileList;
	}
	
	@Test
	@DisplayName("상품등록테스트")
	@WithMockUser(username="admin", roles="ADMIN")
	void saveItem() throws Exception{
		ItemFormDto itemFormDto = new ItemFormDto();
		itemFormDto.setItemNm("테스트상품");
		itemFormDto.setItemSellStatus(ItemSellStatus.SELL);
		itemFormDto.setItemDetail("테스트상품 상세입니다");
		itemFormDto.setPrice(1000);
		itemFormDto.setStockNumber(100);
		
		List<MultipartFile> multipartFileList = createMultipartFiles();
		Long itemId = itemService.saveItem(itemFormDto, multipartFileList);
		Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
		assertEquals(itemFormDto.getItemNm(), item.getItemNm());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
