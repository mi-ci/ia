package com.shop.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartOrderDto {
	private Long cartItemId;
	private List<CartOrderDto> cartOrderDtoList;
}
