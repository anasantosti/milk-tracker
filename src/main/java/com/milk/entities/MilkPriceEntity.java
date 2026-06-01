package com.milk.entities;

import java.math.BigDecimal;

import com.guppycode.audit.AuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class MilkPriceEntity extends AuditEntity {
	
	private static final long serialVersionUID = -2056150381097250832L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal pricePerLiter;
	
	@NotNull
	@Column(nullable = false)
	private Integer year;
	
	@NotNull
	@Column(nullable = false)
	private Integer month;
}
