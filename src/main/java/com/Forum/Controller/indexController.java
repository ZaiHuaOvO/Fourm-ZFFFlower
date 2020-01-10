package com.Forum.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *	@Author	  ZFFFlower  ——2020年1月9日
 *	
 * 
 */
@Controller
public class indexController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
