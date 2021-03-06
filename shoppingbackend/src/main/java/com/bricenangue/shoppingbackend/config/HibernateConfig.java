/**
 * 
 */
package com.bricenangue.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author bricenangue
 *         Configuration of Hibernate to work with the H2 Database
 *
 */

@Configuration
@ComponentScan(basePackages = { "com.bricenangue.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	// change according to DBMS
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";

	// datasource will be available
	@Bean
	public DataSource getDataSource() {

		final BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;
	}

	// Sessionfactory will be available
	@Bean
	public SessionFactory getSessionFactory(final DataSource dataSource) {

		final LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.bricenangue.shoppingbackend.dto");

		return builder.buildSessionFactory();
	}

	// Hibernate Transaction manager will be available
	@Bean
	public HibernateTransactionManager getTransactionManager(final SessionFactory sessionFactory) {

		final HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	/**
	 * 
	 * @return All Hibernate properties
	 */
	private Properties getHibernateProperties() {

		final Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		return properties;
	}

}
