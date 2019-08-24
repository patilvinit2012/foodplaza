package com.vinit.Foodplazabootweb.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JpaConfig {

	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactory() {

		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("foodPlazaUnit");
		return emf;
	}

	@Bean
	public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {

		return new JpaTransactionManager(emf);
	}
}
