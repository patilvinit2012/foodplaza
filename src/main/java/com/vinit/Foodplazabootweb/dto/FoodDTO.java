package com.vinit.Foodplazabootweb.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class FoodDTO {

	private int foodId;

	private String foodName;

	private String foodType;

	private String foodPrice;

	private String foodDesc;

	private String foodQty;
	
	private String imagePath;

	private MultipartFile foodImage;
	
	private String foodImageData;

}
