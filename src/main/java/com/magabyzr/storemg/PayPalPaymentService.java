package com.magabyzr.storemg;

import org.springframework.stereotype.Service;

//@Service("paypal")                                                                    //Bean configuration with annotation. You can also use @Component
public class PayPalPaymentService implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("PAYPAL");
        System.out.println("Amount: " + amount);
    }
}
