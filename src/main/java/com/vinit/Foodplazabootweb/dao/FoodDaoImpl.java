package com.vinit.Foodplazabootweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.vinit.Foodplazabootweb.model.FoodModel;

@Repository
public class FoodDaoImpl implements FoodDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<FoodModel> getAllFoods() {
		TypedQuery<FoodModel> typedQuery = em.createQuery("select f from FoodModel f", FoodModel.class);
		return typedQuery.getResultList();
	}

	@Override
	public FoodModel saveFood(FoodModel f) {
		FoodModel food = em.merge(f);
		return food;
	}

}
