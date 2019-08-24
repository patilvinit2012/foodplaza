package com.vinit.Foodplazabootweb.dao;

import java.util.List;

import com.vinit.Foodplazabootweb.model.FoodModel;

public interface FoodDao {

	List<FoodModel> getAllFoods();

	FoodModel saveFood(FoodModel f);

}
