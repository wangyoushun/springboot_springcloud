package com.six.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class HandlerExceptionResolverTest implements HandlerExceptionResolver {

	//第二种
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		System.out.println("This is exception handler method!");
		String jsonString = JSON.toJSONString(request.getParameterMap());
		log.error("{}:\n接口参数：1{}\n", request.getRequestURI(), jsonString);
		return null;
	}

}
