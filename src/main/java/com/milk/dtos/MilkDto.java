package com.milk.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MilkDto {

	@NotNull
	@Column(nullable = false)
	private BigDecimal liters;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate milkedAt;
}
