package com.bricenangue.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bricenangue.shoppingbackend.dao.CategoryDAO;
import com.bricenangue.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		final ModelAndView mView = new ModelAndView("page");
		mView.addObject("title", "Home");
		mView.addObject("userClickHome", true);

		// passing the list of categories
		mView.addObject("categories", categoryDAO.list());

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

	/*
	 * Methods to load all the products
	 * 
	 */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		final ModelAndView mView = new ModelAndView("page");
		mView.addObject("title", "All Products");
		mView.addObject("categories", categoryDAO.list());

		mView.addObject("userClickAllProducts", true);

		return mView;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") final int id) {
		final ModelAndView mView = new ModelAndView("page");

		Category category = null;

		category = categoryDAO.get(id);

		mView.addObject("title", category.getName());

		mView.addObject("categories", categoryDAO.list());

		// passing category
		mView.addObject("category", category);

		mView.addObject("userClickCategoryProducts", true);
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
