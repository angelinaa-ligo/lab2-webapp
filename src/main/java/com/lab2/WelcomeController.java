package com.lab2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public String welcome() {
	    LocalTime now = LocalTime.now();
	    String greeting = now.isBefore(LocalTime.NOON)
	            ? "Good morning, Angelina"
	            : "Good afternoon, Angelina";
	    return greeting + ", Welcome to COMP367";
	}
}