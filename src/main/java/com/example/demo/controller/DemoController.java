package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope 
@RestController
public class DemoController {
	
	@Value("${message:default}")
	private String prop;

	@RequestMapping(value = "/testConfigServer", method = RequestMethod.GET)
	public String get() {
		return prop;
	}

}
