package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Cart;
import java.util.List;
import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart, Long> {
	Optional<Cart> findById(Long id);
	Cart findByMemberId(Long memberId);
}
