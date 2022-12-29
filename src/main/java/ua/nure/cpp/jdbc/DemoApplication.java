package ua.nure.cpp.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import ua.nure.cpp.jdbc.controller.PolyclinicController;
import ua.nure.cpp.jdbc.dao.connection.DAOConfig;


@SpringBootApplication
@ComponentScan(basePackageClasses= PolyclinicController.class)
@EnableConfigurationProperties(DAOConfig.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
