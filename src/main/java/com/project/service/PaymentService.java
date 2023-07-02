package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.Payment;

public interface PaymentService {
	public void addPayment(Payment payment); 
	public void deletePayment(int id);
	public Optional<Payment> getPayment(int id);
	public List<Payment> getPaymentByUserId(int id);
}