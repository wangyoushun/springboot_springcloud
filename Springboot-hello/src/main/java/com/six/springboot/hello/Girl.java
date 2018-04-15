package com.six.springboot.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * test 属性注入
 */
@ConfigurationProperties(prefix="girl")
@Component
public class Girl {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Girl [name=" + name + ", age=" + age + "]";
	}
	
	
}
