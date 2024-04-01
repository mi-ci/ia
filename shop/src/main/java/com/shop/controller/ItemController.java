package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.dto.ItemFormDto;
import com.shop.dto.ItemImgDto;
import com.shop.dto.MemberFormDto;
import com.shop.entity.Member;

import jakarta.validation.Valid;

@Controller
public class ItemController {
	@GetMapping(value="admin/item/new")
	public String itemForm(Model model) {
		model.addAttribute("itemFormDto", new ItemFormDto());
		return "item/itemForm";
	}
	@PostMapping(value="admin/item/new")
	public String itemForm(@Valid ItemFormDto itemFormDto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "admin/item/new";
		}
		try {
			Item member = Member.createMember(memberFormDto, passwordEncoder);
			memberService.saveMember(member);			
			return "redirect:/";
		} 
		catch (IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "member/memberForm";
		}
	}
}
