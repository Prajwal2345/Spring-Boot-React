package com.crud.RestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class CrudRestApiApplication {

	@RequestMapping("/")
	@ResponseBody
	public static void main(String[] args) {
		SpringApplication.run(CrudRestApiApplication.class, args);
	}

}
