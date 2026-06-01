package com.milk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.milk.entities.MilkEntity;
import com.milk.repositories.MilkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MilkService {

	private final MilkRepository milkRepository;
	
	public List<MilkEntity> findAll() {
		return milkRepository.findAll();
	}
	
	public MilkEntity register(MilkEntity milk) {
		if (milk.getId() != null) {
			Optional<MilkEntity> existingMilk = milkRepository.findById(milk.getId());
			if (existingMilk.isPresent()) {
				MilkEntity milkToUpdate = existingMilk.get();
				milkToUpdate.setLiters(milk.getLiters());
				milkToUpdate.setMilkedAt(milk.getMilkedAt());
	
				return milkRepository.save(milkToUpdate);
			}
		}
		return milkRepository.save(milk);
	}
	
	public Void deleteById(Long id) {
		milkRepository.deleteById(id);
		return null;
	}
}
