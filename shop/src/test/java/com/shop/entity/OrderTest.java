package com.shop.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.shop.constant.ItemSellStatus;
import com.shop.repository.ItemRepository;
import com.shop.repository.MemberRepository;
import com.shop.repository.OrderItemRepository;
import com.shop.repository.OrderRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
@Transactional
public class OrderTest {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	OrderItemRepository orderItemRepository;
	@PersistenceContext
	EntityManager em;
	
	public Item createItem() {
		Item item = new Item();
		item.setItemNm("테스트상품");
		item.setPrice(10000);
		item.setItemDetail("상세설명");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setStockNumber(100);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		return item;
	}
	
	
//	@Test
	@DisplayName("영속성전이테스트")
	public void cascadeTest() {
		Order order = new Order();
		for(int i=0; i<3; i++) {
			Item item = createItem();
			itemRepository.save(item);
			OrderItem orderItem = new OrderItem();
			orderItem.setItem(item);
			orderItem.setOrderPrice(10000);
			orderItem.setCount(10);
			orderItem.setOrder(order);
			orderItem.setRegTime(LocalDateTime.now());
			orderItem.setUpdateTime(LocalDateTime.now());
			order.getOrderItems().add(orderItem);
		}
		orderRepository.saveAndFlush(order);
		em.clear();
		Order savedOrder = orderRepository.findById(order.getId()).orElseThrow(EntityNotFoundException::new);
		assertEquals(3, savedOrder.getOrderItems().size());
		
	}
	public Order createOrder() {
		Order order =  new Order();
		for(int i=0; i<3; i++) {
			Item item = createItem();
			itemRepository.save(item);
			OrderItem orderItem = new OrderItem();
			orderItem.setItem(item);
			orderItem.setOrderPrice(10000);
			orderItem.setCount(10);
			orderItem.setOrder(order);			
			order.getOrderItems().add(orderItem);
		}
		Member member = new Member();
		memberRepository.save(member);
		order.setMember(member);;
		orderRepository.save(order);
		return order;
	}
	
//	@Test
	@DisplayName("고아객체제거테스트")
	public void orphanRemovalTest() {
		Order order = createOrder();
		order.getOrderItems().remove(1);
		em.flush();
	}
	
	@Test
	@DisplayName("지연로딩테스트")
	public void lazyLoadingTest() {
		Order order = createOrder();
		Long orderItemId = order.getOrderItems().get(0).getId();
		em.flush();
		em.clear();
		
		OrderItem orderItem = orderItemRepository.findById(orderItemId).orElseThrow(EntityNotFoundException::new);
		System.out.println("=======" + orderItem.getOrder().getClass());
		System.out.println(orderItem.getOrder().getOrderDate());
	}
	
}
