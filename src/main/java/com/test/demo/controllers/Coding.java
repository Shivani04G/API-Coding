package com.test.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.demo.models.QuizResponse;
import com.test.demo.services.OpenTdb;

@Controller
@RequestMapping("/coding")
public class Coding {
	
	@Autowired
	OpenTdb tdbService;
	
	
	@GetMapping("/exercise/quiz")
	@ResponseBody
	public QuizResponse getData() {
		
		QuizResponse res = tdbService.getData();
		
		return res;
	}

}
