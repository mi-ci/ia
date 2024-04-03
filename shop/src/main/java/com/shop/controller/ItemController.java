package com.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dto.ItemFormDto;
import com.shop.service.ItemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class ItemController {
	
	private final ItemService itemService;
	
	@GetMapping(value="admin/item/new")
	public String itemForm(Model model) {
		model.addAttribute("itemFormDto", new ItemFormDto());
		return "item/itemForm";
	}
	
	@PostMapping(value="admin/item/new")
	public String itemForm(@Valid ItemFormDto itemFormDto, BindingResult bindingResult, Model model, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList) {
		if(bindingResult.hasErrors()) {
			return "item/itemForm";
		}
		if(itemImgFileList.get(0).isEmpty() && itemFormDto.getId()==null) {
			model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력값입니다.");
			return "item/itemForm";
		}
		try {
			itemService.saveItem(itemFormDto, itemImgFileList);
		} 
		catch (Exception e) {
			model.addAttribute("errorMessage", "상품등록 중 에러가 발생하였습니다.");
			return "item/itemForm";
		}
		return "redirect:/";
	}
	
	@GetMapping("admin/item/{itemId}")
	public String itemDtl(@PathVariable("itemId") Long itemId, Model model) {
		try {
			ItemFormDto itemFormDto = itemService.getItemDtl(itemId);
			model.addAttribute("itemFormDto", itemFormDto);
			
		}
		catch (Exception e) {
			model.addAttribute("errorMessage", "존재 하지 않는 상품입니다");
			model.addAttribute("itemFormDto", new ItemFormDto());
			return "item/itemForm";
		}
		return "item/itemForm";
	}
	
	@PostMapping("admin/item/{itemId}")
	public String itemDtl(@Valid ItemFormDto itemFormDto, BindingResult bindingResult, Model model, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList) {
		itemService.updateItem(itemFormDto, itemImgFileList);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
