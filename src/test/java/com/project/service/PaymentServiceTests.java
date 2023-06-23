package com.project.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.model.Payment;
import com.project.repository.PaymentRepository;

class PaymentServiceTests {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPayment() {
        Payment payment = new Payment();
        payment.setPaymentId(1);
        payment.setBookingId(1);
        payment.setPaymentDate("2023-06-01");
        payment.setAmount(100.0);
        payment.setPaymentStatus("Paid");
        payment.setPaymentMethod("Credit Card");

        when(paymentRepository.save(payment)).thenReturn(payment);

        assertDoesNotThrow(() -> paymentService.addPayment(payment));
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void testDeletePayment() {
        Payment payment = new Payment();
        payment.setPaymentId(1);
        payment.setBookingId(1);
        payment.setPaymentDate("2023-06-01");
        payment.setAmount(100.0);
        payment.setPaymentStatus("Paid");
        payment.setPaymentMethod("Credit Card");

        assertDoesNotThrow(() -> paymentService.deletePayment(payment));
        verify(paymentRepository, times(1)).deleteById(payment.getPaymentId());
    }

    @Test
    void testGetPayment() {
        int paymentId = 1;

        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        payment.setBookingId(1);
        payment.setPaymentDate("2023-06-01");
        payment.setAmount(100.0);
        payment.setPaymentStatus("Paid");
        payment.setPaymentMethod("Credit Card");

        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));

        Payment result = paymentService.getPayment(paymentId);

        assertNotNull(result);
        assertEquals(payment, result);
        verify(paymentRepository, times(1)).findById(paymentId);
    }
}