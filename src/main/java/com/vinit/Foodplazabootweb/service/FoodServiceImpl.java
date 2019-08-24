package com.vinit.Foodplazabootweb.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vinit.Foodplazabootweb.dao.FoodDao;
import com.vinit.Foodplazabootweb.dto.FoodDTO;
import com.vinit.Foodplazabootweb.mapper.FoodMapper;
import com.vinit.Foodplazabootweb.model.FoodModel;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao foodDao;

	@Autowired
	@Qualifier("fileServiceImplS3")
	private FileService fileService;

	@Value("${foodservice.folder.imageupload}")
	private String uploadFolder;

	@Autowired
	private SearchService<FoodModel> foodSearchService;

	@Override
	public List<FoodDTO> getAllFoods() {

		List<FoodModel> foodList = foodDao.getAllFoods();

		List<FoodDTO> foodDtoList = FoodMapper.INSTANCE.foodListToFoodDtoList(foodList);

		foodDtoList = foodDtoList.stream().map(foodDTO -> {

			try {
				Path path = Paths.get(foodDTO.getImagePath());
				byte[] bytes = Files.readAllBytes(path);
				String imgData = Base64.encodeBase64String(bytes);
				foodDTO.setFoodImageData(imgData);

			} catch (IOException e) {
				e.printStackTrace();
			}

			return foodDTO;

		}).collect(Collectors.toList());

		return foodDtoList;
	}

	@Override
	public FoodDTO saveFood(FoodDTO foodDTO) {

		FoodModel foodModel = FoodMapper.INSTANCE.foodDtoToFood(foodDTO);

		String imagePath = uploadFoodImage(foodDTO);
		foodModel.setImagePath(imagePath);

		foodModel = foodDao.saveFood(foodModel);

		FoodDTO foodDto = FoodMapper.INSTANCE.foodToFoodDto(foodModel);

		return foodDto;
	}

	private String uploadFoodImage(FoodDTO foodDTO) {
		String imagePath = null;
		try {

			byte[] bytes = foodDTO.getFoodImage().getBytes();
			if (bytes.length != 0) {
				String imageName = UUID.randomUUID().toString() + "-" + foodDTO.getFoodImage().getOriginalFilename();
				imagePath = fileService.uploadFile(imageName, bytes);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return imagePath;
	}

	@Override
	public List<FoodModel> searchFoodByName(String searchStrs) {

		String[] a = { "foodName" };
		return foodSearchService.searchBy(FoodModel.class, searchStrs, a);
	}
}
