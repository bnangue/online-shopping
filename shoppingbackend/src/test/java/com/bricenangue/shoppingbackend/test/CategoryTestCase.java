package com.bricenangue.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bricenangue.shoppingbackend.dao.CategoryDAO;
import com.bricenangue.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.bricenangue.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

//	@Test
//	public void testAddCategory() {
//		category = new Category();
//
//		category.setName("Television");
//		category.setDescription("This is some description for television");
//		category.setImageURL("CAT_1.png");
//
//		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
//	}

//	@Test
//	public void testGetCategory() {
//
//		category = categoryDAO.get(3);
//		assertEquals("Successfully fetched category from table!", "Television", category.getName());
//
//	}
//
//	@Test
//	public void testUpdateCategory() {
//
//		category = categoryDAO.get(3);
//
//		category.setName("TV");
//		assertEquals("Successfully updated category in the table!", true, categoryDAO.update(category));
//
//	}
////	
//	@Test
//	public void testDeleteCategory() {
//
//		category = categoryDAO.get(3);
//
//		assertEquals("Successfully deleted category in the table!", true, categoryDAO.delete(category));
//
//	}

//	@Test
//	public void testGetListCategory() {
//
//		assertEquals("Successfully fetched all active categories from table!", 3, categoryDAO.list().size());
//
//	}

	@Test
	public void testCRUDCategory() {

		// adding a category to the table
		category = new Category();

		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("CAT_1.png");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		// adding second category to table

		category = new Category();

		category.setName("Mobile");
		category.setDescription("This is some description for mobile");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		// getting category from table
		category = categoryDAO.get(1);
		assertEquals("Successfully fetched category from table!", "Television", category.getName());

		// updating category from table

		category = categoryDAO.get(1);

		category.setName("TV");
		assertEquals("Successfully updated category in the table!", true, categoryDAO.update(category));

		// deleting category from table

		category = categoryDAO.get(1);

		assertEquals("Successfully deleted category in the table!", true, categoryDAO.delete(category));

		// getting all categories from table
		assertEquals("Successfully fetched all active categories from table!", 1, categoryDAO.list().size());
	}

}
