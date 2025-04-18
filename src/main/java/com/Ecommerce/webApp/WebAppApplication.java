package com.Ecommerce.webApp;

import com.Ecommerce.webApp.util.SampleDataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
		// Generate sample data
		SampleDataGenerator.generateSampleProducts(10);
	}

}
