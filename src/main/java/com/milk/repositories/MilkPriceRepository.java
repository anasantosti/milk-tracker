package com.milk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milk.entities.MilkPriceEntity;

public interface MilkPriceRepository extends JpaRepository<MilkPriceEntity, Long> {

	Optional<MilkPriceEntity> findByYearAndMonth(Integer year, Integer month);
}
