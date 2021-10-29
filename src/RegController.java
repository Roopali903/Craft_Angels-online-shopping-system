package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RegController {

	@GetMapping("/r")
	public String showRegisPage()
	{
		return "Regist";
	}
	
}
