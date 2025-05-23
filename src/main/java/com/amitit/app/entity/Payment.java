package com.amitit.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;

	private LocalDate paymentDate;

	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	private int amount;
	private String paymentMode;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batch batch;

	@ManyToOne
	@JoinColumn(name = "installment_id")
	private InstallmentType installmentType;

}