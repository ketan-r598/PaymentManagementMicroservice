package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Payment;
import java.util.List;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	public List<Payment> findByUserId(int userId);
}