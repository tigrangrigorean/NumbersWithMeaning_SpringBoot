package com.numbers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.numbers.service.NumberService;

@RestController
public class NumberController {
	
	private final NumberService numberService;
	
	@Autowired
	public NumberController(NumberService numberService) {
		this.numberService = numberService;
	}
	

	@GetMapping("/{number}")
	public ResponseEntity<String> getFact(@PathVariable long number) {
		return ResponseEntity.ok().body(numberService.getFactAboutNumber(number));
	}
	
	@GetMapping("/{number}/math")
	public ResponseEntity<String> getFactMath(@PathVariable long number) {
		return ResponseEntity.ok().body(numberService.getMathFactAboutNumber(number));
	}
	
	@GetMapping("/{month}/{day}/date")
	public ResponseEntity<String> getFactMath(@PathVariable int month, @PathVariable int day) {
		return ResponseEntity.ok().body(numberService.getFactInDate(month,day));
	}
	
	@GetMapping("/error")
	public ResponseEntity<String> error() {
		return ResponseEntity.status(404).body("Oops. Something goes wrong");
	}
}
