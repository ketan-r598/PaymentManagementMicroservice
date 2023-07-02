package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Payment;
import com.project.service.PaymentService;

import jakarta.ws.rs.core.Response;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/payments/customer/")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@PostMapping("add")
	public void addPayment(@RequestBody Payment payment) {
		System.out.println(payment);
		service.addPayment(payment);
		
//		try {
//			service.addPayment(payment);
//		} catch (DuplicatePaymentIDException e) {
//			System.out.println("\nCannot add the payment\n");
//			System.out.println(e);
////			e.printStackTrace();
//		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePayment(@PathVariable int id) {
		service.deletePayment(id);
//		try {
//			service.deletePayment(payment);
//		} catch (PaymentDoesNotExistException e) {
//			System.out.println("\nCannot delete the hotel\n");
//			System.out.println(e);
////			e.printStackTrace();
//		}
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("getPaymentByUserId/{userId}")
	public List<Payment> getPaymentByUserId(@PathVariable int userId) {
		return service.getPaymentByUserId(userId);
	}
	
	@GetMapping("getPayment/{id}")
	public Payment getPayment(@PathVariable int id)  {
		
		Optional<Payment> p = service.getPayment(id);
		
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