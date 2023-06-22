package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.base.Optional;
import com.project.model.Payment;
import com.project.service.PaymentService;

@Controller
@RequestMapping("/payments/")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@PostMapping("customer/add")
	public void addPayment(Payment payment) {
		service.addPayment(payment);
//		try {
//			service.addPayment(payment);
//		} catch (DuplicatePaymentIDException e) {
//			System.out.println("\nCannot add the payment\n");
//			System.out.println(e);
////			e.printStackTrace();
//		}
	}
	
	@DeleteMapping("customer/delete")
	public void deletePayment(Payment payment) {
		service.deletePayment(payment);
//		try {
//			service.deletePayment(payment);
//		} catch (PaymentDoesNotExistException e) {
//			System.out.println("\nCannot delete the hotel\n");
//			System.out.println(e);
////			e.printStackTrace();
//		}
	}
	
	@GetMapping("customer/getPayment")
	public Payment getPayment(int id)  {
		
		Optional<Payment> p = Optional.of(service.getPayment(id));
		
		if(p.isPresent()) {
				return p.get();
		} else {
			System.out.println("Payment Doesn't Exist");
			return null;
		}
		
//		Payment payment = null;
//		try {
//			payment = service.getPayment(id);
//		} catch (PaymentDoesNotExistException e) {
//			System.out.println("\nCannot find the hotel\n");
//			System.out.println(e);
//			return null;
////			e.printStackTrace();
//		}
//		return payment;
	}
}