package com.milk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.milk.entities.MilkPriceEntity;
import com.milk.repositories.MilkPriceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MilkPriceService {

	private final MilkPriceRepository milkPriceRepository;
	
	public List<MilkPriceEntity> findAll() {
		return milkPriceRepository.findAll();
	}
	
	public Optional<MilkPriceEntity> findPriceByYearAndMonth(Integer year, Integer month) {
		return milkPriceRepository.findByYearAndMonth(year, month);
	}
	
	public MilkPriceEntity register(MilkPriceEntity milkPrice) {
		if (milkPrice.getId() != null) {
			Optional<MilkPriceEntity> existingPrice = milkPriceRepository.findById(milkPrice.getId());
			if (existingPrice.isPresent()) {
				MilkPriceEntity priceToUpdate = existingPrice.get();
				priceToUpdate.setPricePerLiter(milkPrice.getPricePerLiter());
				priceToUpdate.setYear(milkPrice.getYear());
				priceToUpdate.setMonth(milkPrice.getMonth());
				return milkPriceRepository.save(priceToUpdate);
			}
		}
		
		return milkPriceRepository.save(milkPrice);
	}
	
}
