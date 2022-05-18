package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Hotel;
import com.example.demo.service.HotelService;

@Controller
@RequestMapping("hotel")
public class HotelController {

	@Autowired
	private HotelService service;


	@RequestMapping("")
	public String index() {
		return "/exam2/hotelsearch";
	}

	@RequestMapping("findbyprice")
	public String findByPrice(Integer price, Model model) {
		List<Hotel> hotellist = service.findByPrice(price);
		model.addAttribute("hotellist", hotellist);
		return "/exam2/hotelsearch";
	}


}
