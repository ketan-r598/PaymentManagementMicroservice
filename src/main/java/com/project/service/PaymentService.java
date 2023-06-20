package com.project.service;

import com.project.model.Payment;

public interface PaymentService {
	public void addPayment(Payment payment); 
	public void deletePayment(Payment payment);
	public Payment getPayment(int id);
}