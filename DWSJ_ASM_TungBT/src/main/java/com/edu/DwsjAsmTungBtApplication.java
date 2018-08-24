package com.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.edu")
public class DwsjAsmTungBtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DwsjAsmTungBtApplication.class, args);
	}
}
