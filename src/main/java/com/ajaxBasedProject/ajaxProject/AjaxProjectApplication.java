package com.ajaxBasedProject.ajaxProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.ajaxBasedProject.ajaxProject.controller.UserController;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AjaxProjectApplication {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(AjaxProjectApplication.class, args);

			System.out.println("Welcome to Ajax Project ");

		}catch(Throwable e) {

			if(e.getClass().getName().contains("SilentExitException")) {
				LOGGER.debug("Spring is restarting the main thread - See spring-boot-devtools");
			} else {
				LOGGER.error("Application crashed!", e);
			}

		}

	}

}



