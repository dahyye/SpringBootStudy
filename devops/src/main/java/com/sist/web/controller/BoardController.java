package com.sist.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class BoardController {
	@GetMapping("/board/list")
	public String board_list(Model model)
	{
		model.addAttribute("main_html","board/list");
		return "index";
	}
	
	@GetMapping("/board/insert")
	public String board_insert(Model model)
	{
		model.addAttribute("main_html","board/list");
		return "index";
	}
	
	@GetMapping("/board/detail")
	public String board_detail(Model model)
	{
		model.addAttribute("main_html","board/list");
		return "index";
	}
}
