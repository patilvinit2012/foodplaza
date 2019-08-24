package com.vinit.Foodplazabootweb.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

	@Value("${foodservice.folder.imageupload}")
	private String uploadFolder;

	@Override
	public String uploadFile(String imageName, byte[] bytes) {
		String imagePath = null;
		try {

			imagePath = uploadFolder + imageName;
			Path path = Paths.get(imagePath);
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagePath;
	}
}
