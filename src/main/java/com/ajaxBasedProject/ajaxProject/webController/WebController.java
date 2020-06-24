package com.ajaxBasedProject.ajaxProject.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@GetMapping("/")
	public String homepage(){
        return "submit";
    }
	
}
