package com.bricenangue.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "/", "/home", "/index" })

	public ModelAndView index() {
		final ModelAndView mView = new ModelAndView("page");
		mView.addObject("greeting", "Welcome to tSpring MVC");

		return mView;
	}

//	@RequestMapping(value = { "/test" })
//	public ModelAndView test(@RequestParam(value = "greeting", required = false) String greeting) {
//		if (greeting == null) {
//			greeting = "Hello World";
//		}
//		final ModelAndView mView = new ModelAndView("page");
//		mView.addObject("greeting", greeting);
//
//		return mView;
//	}

//	@RequestMapping(value = { "/test/{greeting}" })
//	public ModelAndView test(@PathVariable("greeting") String greeting) {
//		if (greeting == null) {
//			greeting = "Hello World";
//		}
//		final ModelAndView mView = new ModelAndView("page");
//		mView.addObject("greeting", greeting);
//
//		return mView;
//	}
}
