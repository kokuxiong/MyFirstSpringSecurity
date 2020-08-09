package com.koku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/vip1")
	public String linkToVip1() {
		return "vip1";
	}
	
	@GetMapping("/vip2")
	public String linkToVip2() {
		return "vip2";
	}
	
	@GetMapping("/vip3")
	public String linkToVip3() {
		return "vip3";
	}
}
