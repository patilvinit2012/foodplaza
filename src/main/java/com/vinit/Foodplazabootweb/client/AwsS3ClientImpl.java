package com.vinit.Foodplazabootweb.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

@Component
public class AwsS3ClientImpl implements AwsS3Client {

	@Autowired
	ResourceLoader resourceLoader;
	
	@Autowired
	@Lazy
	public AwsS3ClientImpl(@Lazy String s) {
		
	}

	@Autowired
	ResourcePatternResolver resourcePatternResolver;

	@Override
	public void downloadS3Object(String s3Url) throws IOException {
		Resource resource = resourceLoader.getResource(s3Url);
		File downloadedS3Object = new File(resource.getFilename());

		try (InputStream inputStream = resource.getInputStream()) {
			Files.copy(inputStream, downloadedS3Object.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	/**
	 * s3Url format: s3://<bucket>/<object> s3Url : s3://my-s3-bucket/foo/bar.zip
	 * 
	 */
	// s3://my-s3-bucket/**/a*.txt
	@Override
	public void uploadFileToS3(File file, String s3Url) throws IOException {
		WritableResource resource = (WritableResource) resourceLoader.getResource(s3Url);

		try (OutputStream outputStream = resource.getOutputStream()) {
			Files.copy(file.toPath(), outputStream);
		}
	}

	@Override
	public void downloadMultipleS3Objects(String s3Url) throws IOException {
		Resource[] allFileMatchingPatten = this.resourcePatternResolver.getResources(s3Url);

	}
}
