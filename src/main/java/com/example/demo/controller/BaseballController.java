package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Baseballteam;
import com.example.demo.form.BaseballForm;
import com.example.demo.service.BaseballService;

/**
 * @author 81802
 *
 */
@Controller
@RequestMapping("/baseball")
public class BaseballController {

	@Autowired
	private BaseballService service;

	@ModelAttribute
	public BaseballForm setUpBaseballForm() {
		return new BaseballForm();
	}

//野球チーム一覧を表示するメソッド
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Baseballteam> teamlist = service.findAll();
		model.addAttribute("teamlist", teamlist);
		return "exam1/baseballteam";
	}

//野球チーム詳細を表示するメソッド
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Baseballteam baseball = service.load(Integer.parseInt(id));
		model.addAttribute("baseball", baseball);
		return "exam1/teamdetail";
	}


}
