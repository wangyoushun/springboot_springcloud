package com.six.springboot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//等同于同时加上了@Controller和@ResponseBody
@RestController
@EnableConfigurationProperties({Girl.class})
public class HelloController {

	@Autowired
	private Girl girl;

	@Value("${girl.name}")
	private String name;

	// 将配置文件的属性赋给实体类
	@RequestMapping("/hello")
	public String index() {
		System.out.println(girl);
		return "Spring Boot! hello world";
	}

	// 自定义属性
	@RequestMapping("/name")
	public String name() {
		System.out.println(name);
		return name.toString();
	}

}
