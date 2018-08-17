package com.six.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebExceptionHandle {

	@ExceptionHandler()
	@ResponseBody
	String handleException(Exception e) {
		return "Exception Deal! " + e.getMessage();
	}
}