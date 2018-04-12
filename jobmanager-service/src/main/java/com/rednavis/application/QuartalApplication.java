package com.rednavis.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point to the application.
 * This class starts embedded TomCat server under the hood
 * and deploys application to it
 *
 * Created by Eugene Tsydzik
 * on 4/12/18.
 */
@SpringBootApplication
public class QuartalApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.rednavis.application.QuartalApplication.class, args);
	}
}
