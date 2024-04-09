package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dto.OrderDto;
import com.shop.entity.Item;
import com.shop.entity.Member;
import com.shop.entity.Order;
import com.shop.entity.OrderItem;
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
}
