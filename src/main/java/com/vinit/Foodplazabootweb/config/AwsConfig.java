package com.vinit.Foodplazabootweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsConfig {

	@Bean
	public AmazonS3 getAmazonS3() {

		AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard().withCredentials(getAWSCredentialsProvider())
				.withRegion(Regions.AP_SOUTH_1).build();
		return amazonS3;
	}

	private AWSCredentialsProvider getAWSCredentialsProvider() {
		return new DefaultAWSCredentialsProviderChain();
	}
}
