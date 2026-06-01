package com.milk.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milk.dtos.MilkDto;
import com.milk.entities.MilkEntity;
import com.milk.services.MilkService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("milks")
@RequiredArgsConstructor
public class MilkController {

	private final MilkService milkService;
	
	@GetMapping
	public ResponseEntity<List<MilkEntity>> findAllMilk() {
		return ResponseEntity.ok(milkService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<MilkEntity> registierMilk(@RequestBody @Valid MilkDto milkDto) {
		MilkEntity milk = new MilkEntity();
		milk.setLiters(milkDto.getLiters());
		milk.setMilkedAt(milkDto.getMilkedAt());
		return ResponseEntity.ok(milkService.register(milk));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<MilkEntity> update(@PathVariable Long id, @RequestBody @Valid MilkDto milkDto) {
		MilkEntity milk = new MilkEntity();
		milk.setId(id);
		milk.setLiters(milkDto.getLiters());
		milk.setMilkedAt(milkDto.getMilkedAt());
		return ResponseEntity.ok(milkService.register(milk));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		milkService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
