package com.shop.dto;

import com.shop.entity.OrderItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
	private String itemNm;
	private int count;
	private int orderPrice;
	private String imgUrl;
	
	public OrderItemDto(OrderItem orderItem, String imgUrl) {
		itemNm = orderItem.getItem().getItemNm();
		count = orderItem.getCount();
		orderPrice = orderItem.getOrderPrice();
		this.imgUrl = imgUrl;
	}
}
