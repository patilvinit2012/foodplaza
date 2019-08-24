package com.vinit.Foodplazabootweb.service;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vinit.Foodplazabootweb.client.AwsS3Client;

@Service
public class FileServiceImplS3 implements FileService {

	@Autowired
	private AwsS3Client s3Client;

	@Value("${aws.s3.bucket}")
	private String bucketName;

	@Value("${aws.s3.images.food}")
	private String foodImagesFolder;

	@Override
	public String uploadFile(String imageName, byte[] bytes) {
		String s3Url = null;

		try {
			s3Url = bucketName + foodImagesFolder + imageName.replace(" ", "_");

			File file = new File(imageName);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes);
			fos.close();

			s3Client.uploadFileToS3(file, s3Url);
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s3Url;
	}

}
