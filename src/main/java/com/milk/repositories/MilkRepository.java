package com.milk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milk.entities.MilkEntity;

public interface MilkRepository extends JpaRepository<MilkEntity, Long> {

}
