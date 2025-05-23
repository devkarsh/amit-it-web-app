package com.amitit.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Installement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int installmentId;

	@Enumerated(EnumType.STRING)
	private InstallmentType installmentType;

	private int numberOfParts;
	private boolean hasDiscount;
	private Double discountPercent;

}