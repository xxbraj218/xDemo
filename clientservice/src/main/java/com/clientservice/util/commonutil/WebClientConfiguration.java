package com.clientservice.util.commonutil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;



@Configuration
public class WebClientConfiguration {
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
	public static final int TIMEOUT = 1000;

	@Bean
	public RestTemplate getClientwithTimeout() {
		int timeout = 5000;
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(timeout);

		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		return restTemplate;
	}
}