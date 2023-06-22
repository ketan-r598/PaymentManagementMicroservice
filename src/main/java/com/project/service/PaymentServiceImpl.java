package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Payment;
import com.project.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repo;
	
	@Override
	public void addPayment(Payment payment) {
		int id = payment.getPaymentId();
		Optional<Payment> p = repo.findById(id);

		if (p.isEmpty()) {
			repo.save(payment);
			System.out.println("\nPayment Saved Successfully\n");
			return;
		}
//		throw new DuplicatePaymentIDException();
		
	}

	@Override
	public void deletePayment(Payment payment) {
		int id = payment.getPaymentId();
		Optional<Payment> p = repo.findById(id);

		if (p.isEmpty()) {
//			throw new PaymentDoesNotExistException();
		}
		repo.deleteById(id);
		System.out.println("\nPayment Deleted Successfully\n");
		
	}

	@Override
	public Payment getPayment(int id) {
		Optional<Payment> p = repo.findById(id);

		if (p.isEmpty()) {
//			throw new PaymentDoesNotExistException();
		}
		return p.get();
	}

}