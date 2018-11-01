package com.bricenangue.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bricenangue.shoppingbackend.dao.CategoryDAO;
import com.bricenangue.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		// Hibernate query
		final String selectCategory = "FROM Category WHERE active = :active";

		final Query<Category> query = sessionFactory.getCurrentSession().createQuery(selectCategory);

		query.setParameter("active", true);

		return query.getResultList();
	}

	/**
	 * 
	 * @param id
	 * @return a category based on the id parameter
	 */
	@Override
	public Category get(final int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(final Category category) {
		try {
			// add the Category to the database table

			sessionFactory.getCurrentSession().persist(category);

			return true;

		} catch (final Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Update a single Category
	 * 
	 * @param category
	 * @return
	 */
	@Override
	public boolean update(final Category category) {
		try {
			// update the Category to the database table

			sessionFactory.getCurrentSession().update(category);

			return true;

		} catch (final Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(final Category category) {
		try {
			// set category false the Category to the database table

			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);

			return true;

		} catch (final Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
