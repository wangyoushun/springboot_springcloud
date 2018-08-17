package com.six.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test2ExceptionController {

	//第一种  使用 @ ExceptionHandler 注解
	@RequestMapping("/test01")
	public String test01() {
		int i=1/0;
		
		return "success";
	}
	
	@RequestMapping("/test02")
	public String test02() {
		return "success";
	}
}
