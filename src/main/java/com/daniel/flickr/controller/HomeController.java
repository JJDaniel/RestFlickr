package com.daniel.flickr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.daniel.flickr.model.Root;
import com.daniel.flickr.model.metadata.MetadataRoot;

@Controller
public class HomeController {
	//TODO: Need to move url to properties file
	private String url = "https://api.flickr.com/services/rest/?api_key=XXX&format=json&nojsoncallback=1";
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping(value="/images/{tag}", method = RequestMethod.GET)
	String getImages(@PathVariable String tag, @RequestParam(value="sort", required=false) String sort, Model model){
		//assumes tag as required and sort as optional
		//need to add better error display
		url += "&method=flickr.photos.search";
		url += "&tags=" + tag;
		if(sort != null && !sort.isEmpty())
			url += "&sort=" + sort;
		
		System.out.println("***URL: " + url);	//TODO: Need to change to proper logging
		
		Root root = restTemplate.getForObject(url, Root.class);
        model.addAttribute("root", root);
		return "Images";
	}
	
	@RequestMapping(value="/images/id/{id}", method = RequestMethod.GET)
	String getImageMetadata(@PathVariable String id, Model model){
		url += "&method=flickr.photos.getInfo";	
		url += "&photo_id=" + id;
		
		System.out.println("***URL: " + url);	//TODO: Need to change to proper logging
		
		MetadataRoot root = restTemplate.getForObject(url, MetadataRoot.class);
        model.addAttribute("image", root);
		return "Image";
	}


}
