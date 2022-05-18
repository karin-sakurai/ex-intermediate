package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Clothes;
import com.example.demo.service.ClothesService;

@Controller
@RequestMapping("clothes")
public class ClothesController {

	@Autowired
	private ClothesService service;

	@RequestMapping("")
	public String index() {
		return "/exam3/clothes";
	}

	@RequestMapping("find")
	public String findClothes(Integer gender, String color, Model model) {
		List<Clothes> clotheslist = service.findClothes(gender, color);
		model.addAttribute("clotheslist", clotheslist);
		return "/exam3/clothes";
	}

}
