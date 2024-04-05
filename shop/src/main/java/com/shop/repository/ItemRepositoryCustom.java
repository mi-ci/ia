package com.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.dto.ItemSearchDto;
import com.shop.entity.Item;

public interface ItemRepositoryCustom {
	Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
