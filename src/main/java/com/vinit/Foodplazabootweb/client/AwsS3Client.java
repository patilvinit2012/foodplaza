package com.vinit.Foodplazabootweb.client;

import java.io.File;
import java.io.IOException;

public interface AwsS3Client {

	void downloadS3Object(String s3Url) throws IOException;

	void uploadFileToS3(File file, String s3Url) throws IOException;

	void downloadMultipleS3Objects(String s3Url) throws IOException;
	
}