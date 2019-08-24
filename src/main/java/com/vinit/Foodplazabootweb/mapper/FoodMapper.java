package com.vinit.Foodplazabootweb.mapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vinit.Foodplazabootweb.dto.FoodDTO;
import com.vinit.Foodplazabootweb.model.FoodModel;

@Mapper
@DecoratedWith(FoodMapperDecorator.class)
public interface FoodMapper {

	FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

	FoodModel foodDtoToFood(FoodDTO foodDto);

	FoodDTO foodToFoodDto(FoodModel food);

	List<FoodDTO> foodListToFoodDtoList(List<FoodModel> foodList);

}

abstract class FoodMapperDecorator implements FoodMapper {

	private final FoodMapper delegate;

	public FoodMapperDecorator(FoodMapper delegate) {
		this.delegate = delegate;
	}

	@Override
	public FoodModel foodDtoToFood(FoodDTO foodDto) {
		FoodModel f = delegate.foodDtoToFood(foodDto);
		System.out.println("in foodDtoToFood food mapper delegate1");
		return f;
	}

	@Override
	public FoodDTO foodToFoodDto(FoodModel food) {
		System.out.println("in  foodToFoodDto food mapper delegate");
		FoodDTO foodDTO = delegate.foodToFoodDto(food);

		try {
			if(food.getImagePath() != null) {
				
			}
			Path path = Paths.get(food.getImagePath());
			byte[] bytes = Files.readAllBytes(path);
			String imgData = Base64.encodeBase64String(bytes);
			foodDTO.setFoodImageData(imgData);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return foodDTO;
	}
}
