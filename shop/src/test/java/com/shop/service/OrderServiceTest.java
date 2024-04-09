package com.shop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.OrderDto;
import com.shop.entity.Item;
import com.shop.entity.Member;
import com.shop.entity.Order;
import com.shop.entity.OrderItem;
import com.shop.repository.ItemRepository;
import com.shop.repository.MemberRepository;
import com.shop.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application.properties")

public class OrderServiceTest {

   
   @Autowired
   private OrderService orderService;
   
   @Autowired
   private OrderRepository orderRepository;
   
   @Autowired
   private ItemRepository itemRepository;
   
   @Autowired
   private MemberRepository memberRepository;
   
   public Item saveItem() {
      Item item=new Item();
      item.setItemNm("테스트 상품");
      item.setPrice(10000);
      item.setItemDetail("테스트상품 상세설명");
      item.setItemSellStatus(ItemSellStatus.SELL);
      item.setStockNumber(100);
      return itemRepository.save(item);
   }
   
   public Member saveMember() {
      Member member=new Member();
      member.setEmail("test@test.com");
      return memberRepository.save(member);
   }
   
   @Test
   @DisplayName("주문 테스트")
   
   public void order() {
      Item item=saveItem();
      Member member=saveMember();
      
      OrderDto orderDto=new OrderDto();
      orderDto.setCount(10);
      orderDto.setItemId(item.getId());
      System.out.println("item.getId()=====>"+item.getId());
      Long orderId = orderService.order(orderDto, member.getEmail());
      
      Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
      List<OrderItem> orderItem = order.getOrderItems();
      int totalPrice = orderDto.getCount()*item.getPrice();
      
      assertEquals(totalPrice, order.getTotalPrice());
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   }
}
