package com.six.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractController {

	@ExceptionHandler
	@ResponseBody
	public String handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		String jsonString = JSON.toJSONString(request.getParameterMap());
		log.error("{}:\n接口参数：{}\n", request.getRequestURI(), jsonString);
		return "handleException " + jsonString;
	}
}
