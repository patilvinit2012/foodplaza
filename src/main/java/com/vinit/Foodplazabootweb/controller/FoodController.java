package com.vinit.Foodplazabootweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vinit.Foodplazabootweb.dto.FoodDTO;
import com.vinit.Foodplazabootweb.model.FoodModel;
import com.vinit.Foodplazabootweb.service.FoodService;

@Controller
@RequestMapping("food")
public class FoodController {

	@Autowired
	private FoodService foodService;

	@GetMapping("all")
	public String getAllFoodList(Model model) {
		model.addAttribute("foods", foodService.getAllFoods());

		return "food/all";
	}

	@GetMapping("add")
	public String addNewFood(FoodDTO food, Model model) {
		model.addAttribute("food", new FoodDTO());
		return "food/add";
	}

	@PostMapping("add")
	public String saveNewFood(FoodDTO food, Model model) {
		foodService.saveFood(food);
		return "redirect:all";
	}
	
	@GetMapping("search")
	@ResponseBody
	public List<FoodModel> method(@RequestParam String q) {
		return foodService.searchFoodByName(q);
	}
}
