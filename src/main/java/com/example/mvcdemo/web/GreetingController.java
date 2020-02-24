package com.example.mvcdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

	@GetMapping
	public String getGreeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("num", 0);
		return "greeting";
	}

	@GetMapping(value = "/ajax-number")
	public String getEventCount(Model mode) {
		int num = ThreadLocalRandom.current().nextInt(100);
		mode.addAttribute("num", num);
		return "greeting :: #ajaxNumber";
	}

}