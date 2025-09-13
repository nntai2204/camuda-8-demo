package com.example.demo;

import com.example.demo.service.CamundaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final CamundaService camundaService;

	public DemoApplication(CamundaService camundaService) {
		this.camundaService = camundaService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		camundaService.deployProcess();
		camundaService.startProcess();
	}
}
