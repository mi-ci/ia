package com.shop.dto;


import com.shop.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto extends BaseEntity {
   
	private Long id;
	private String itemNm;
	private Integer price;
	private String itemDetail;
	private String sellStartCd;
	
}
