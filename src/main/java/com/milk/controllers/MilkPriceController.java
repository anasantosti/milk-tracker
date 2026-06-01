package com.milk.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milk.entities.MilkPriceEntity;
import com.milk.services.MilkPriceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("milk-prices")
@RequiredArgsConstructor
public class MilkPriceController {

	private final MilkPriceService milkPriceService;
	
	@GetMapping
	public ResponseEntity<List<MilkPriceEntity>> findAll() {
		return ResponseEntity.ok(milkPriceService.findAll());
	}
	
	@GetMapping("{year}/{month}")
	public ResponseEntity<Optional<MilkPriceEntity>> findPriceByYearAndMonth(@PathVariable Integer year, @PathVariable Integer month) {
		return ResponseEntity.ok(milkPriceService.findPriceByYearAndMonth(year, month));
	}
	
	@PostMapping
	public ResponseEntity<MilkPriceEntity> register(@RequestBody @Valid MilkPriceEntity milkPrice) {
		return ResponseEntity.ok(milkPriceService.register(milkPrice));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<MilkPriceEntity> register(@PathVariable Long id, @RequestBody @Valid MilkPriceEntity milkPrice) {
		milkPrice.setId(id);
		return ResponseEntity.ok(milkPriceService.register(milkPrice));
	}
}
