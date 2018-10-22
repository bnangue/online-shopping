package com.bricenangue.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		final ModelAndView mView = new ModelAndView("page");
		mView.addObject("title", "Home");
		mView.addObject("userClickHome", true);

		return mView;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		final ModelAndView mView = new ModelAndView("page");
		mView.addObject("title", "About Us");
		mView.addObject("userClickAbout", true);

		return mView;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		final ModelAndView mView = new ModelAndView("page");
		mView.addObject("title", "Contact Us");
		mView.addObject("userClickContact", true);

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

//	@RequestMapping(value = "/test/{greeting}")
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
