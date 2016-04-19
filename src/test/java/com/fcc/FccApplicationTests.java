package com.fcc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.daniel.flickr.FlickrApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlickrApplication.class)
@WebAppConfiguration
public class FccApplicationTests {

	@Test
	public void contextLoads() {
	}

}
