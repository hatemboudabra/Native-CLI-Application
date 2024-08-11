package com.example.native_CLI_Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.EnableCommand;

@SpringBootApplication
public class NativeCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(NativeCliApplication.class, args);
	}

}
