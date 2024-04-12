package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.shop.dto.OrderDto;
import com.shop.dto.OrderHistDto;
import com.shop.dto.OrderItemDto;
import com.shop.entity.Item;
import com.shop.entity.ItemImg;
import com.shop.entity.Member;
import com.shop.entity.Order;
import com.shop.entity.OrderItem;
import com.shop.repository.ItemImgRepository;
import com.shop.repository.ItemRepository;
import com.shop.repository.MemberRepository;
import com.shop.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
	private final ItemRepository itemRepository;
	private final MemberRepository memberRepository;
	private final OrderRepository orderRepository;
	private final ItemImgRepository itemImgRepository;
	
	public Long order(OrderDto orderDto, String email) {
		Item item = itemRepository.findById(orderDto.getItemId()).orElseThrow(EntityNotFoundException::new);
		Member member = memberRepository.findByEmail(email);
		List<OrderItem> orderItemList = new ArrayList<>();
		
		OrderItem orderItem = OrderItem.createdOrderItem(item, orderDto.getCount());
		orderItemList.add(orderItem);
		
		Order order = Order.createdOrder(member, orderItemList);
		orderRepository.save(order);
		return order.getId();
	}
	
	@Transactional(readOnly=true)
	public Page<OrderHistDto> getOrderList(String email, Pageable pageable){
		List<Order> orders = orderRepository.findOrders(email, pageable);
		Long totalCount = orderRepository.countOrder(email);
		List<OrderHistDto> orderHistDtos = new ArrayList<>();
		for (Order order : orders) {
			OrderHistDto orderHistDto = new OrderHistDto(order);
			List<OrderItem> orderItems = order.getOrderItems();
			for(OrderItem orderItem : orderItems) {
				ItemImg itemImg = itemImgRepository.findByItemIdAndRepImgYn(orderItem.getItem().getId(), "Y");
				OrderItemDto orderItemDto = new OrderItemDto(orderItem, itemImg.getImgUrl());
				orderHistDto.addOrderItemDto(orderItemDto);
			}
			orderHistDtos.add(orderHistDto);
		}
		return new PageImpl<OrderHistDto>(orderHistDtos, pageable, totalCount);
		
	}
	
	@Transactional(readOnly = true)
	public boolean validateOrder(Long orderId, String email) {
		Member curMember = memberRepository.findByEmail(email);
		Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
		Member savedMember = order.getMember();
		if(!StringUtils.equals(curMember.getEmail(), savedMember.getEmail())) {
			return false;
		}
		return true;
	}
	
	public void cancelOrder(Long orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
		order.cancelOrder();
	}
	
	public Long orders( List<OrderDto> orderDtoList, String email ) {
	       Member member = memberRepository.findByEmail(email);
	       List<OrderItem> orderItemList = new ArrayList<>();
	       for( OrderDto orderDto : orderDtoList) {
	    	 //주문할 상품 리스트를 만들어 줍니다
	    	   Item item = itemRepository.findById(orderDto.getItemId())
	    	                             .orElseThrow(EntityNotFoundException::new);
	    	   OrderItem orderItem = OrderItem.createdOrderItem(item, orderDto.getCount() );
	    	   orderItemList.add(orderItem);
	        }
	       //현재 로그인한 회원과 주문상품 목록을 이용하여 주문 엔티티를 만든다
	        Order order = Order.createdOrder(member, orderItemList);
	        //주문데이터를 저장합니다
	        orderRepository.save(order);
	        return order.getId();
	    }
	
	
	
	
}
