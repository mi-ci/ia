package com.shop.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemFormDto {
	private long id;
	@NotBlank(message="상품명은 필수 입력값입니다")
	private String itemNm;
	@NotNull(message="상품명은 필수 입력값입니다")
	private int price;
	@NotBlank(message = "이름은 필수 입력값입니다")
	private String itemDetail;
	@NotNull(message = "재고는 필수 입력값입니다")
	private int stockNumber;
	
	private ItemSellStatus itemSellStatus;
	
	private List<ItemImgDto> itemImgDtoList = new ArrayList<ItemImgDto>();
	private List<Long> itemImgIds = new ArrayList<Long>();
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Item createItem() {
		return modelMapper.map(this, Item.class);
	}
	public static ItemFormDto of(Item item) {
		return modelMapper.map(item, ItemFormDto.class);
	}
}
