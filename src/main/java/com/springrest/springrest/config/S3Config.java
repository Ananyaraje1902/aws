package com.springrest.springrest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {

	@Value("${aws.accesskey}")
	private String accessKey;
	
	@Value("${aws.secretkey}")
	private String secretkey;
	
	@Bean
	public AmazonS3 s3Client() {
		
		BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey,secretkey);
		return AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
				.withRegion("eu-north-1")
				.build();
		
	}
}
