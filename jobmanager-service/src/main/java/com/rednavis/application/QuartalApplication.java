package com.rednavis.application;


import com.rednavis.application.config.QuartalAppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Entry point to the application.
 * This class starts embedded TomCat server under the hood
 * and deploys application to it
 *
 * Created by Eugene Tsydzik
 * on 4/12/18.
 */
@SpringBootApplication
@Import(QuartalAppConfiguration.class)
public class QuartalApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.rednavis.application.QuartalApplication.class, args);
	}
}
