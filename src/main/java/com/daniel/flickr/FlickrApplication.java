package com.daniel.flickr;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class FlickrApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlickrApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		ArrayList<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(new MediaType("application", "json", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET));
		mediaTypes.add(new MediaType("text", "javascript", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET));
		
	    RestTemplate restTemplate = new RestTemplate();
	    List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
	    for (HttpMessageConverter<?> converter : converters) {
	        if (converter instanceof MappingJackson2HttpMessageConverter) {
	            MappingJackson2HttpMessageConverter jsonConverter = (MappingJackson2HttpMessageConverter) converter;
	            jsonConverter.setObjectMapper(new ObjectMapper()); 
	            jsonConverter.setSupportedMediaTypes(mediaTypes);
	        }
	    }
	    return restTemplate;
	}
	
}
