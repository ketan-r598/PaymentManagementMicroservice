package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int paymentId;
	
	int bookingId;
	String paymentDate;
	double amount;
	String paymentStatus;
	String paymentMethod;
	
	public Payment() {
		
	}

	public Payment(int paymentId, int bookingId, String paymentDate, double amount, String paymentStatus,
			String paymentMethod) {
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", bookingId=" + bookingId + ", paymentDate=" + paymentDate
				+ ", amount=" + amount + ", paymentStatus=" + paymentStatus + ", paymentMethod=" + paymentMethod + "]";
	}
}
