package com.vinit.Foodplazabootweb.service;

import java.util.List;

import com.vinit.Foodplazabootweb.dto.FoodDTO;
import com.vinit.Foodplazabootweb.model.FoodModel;

public interface FoodService {

	List<FoodDTO> getAllFoods();

	FoodDTO saveFood(FoodDTO f);

	List<FoodModel> searchFoodByName(String searchStr);

}
