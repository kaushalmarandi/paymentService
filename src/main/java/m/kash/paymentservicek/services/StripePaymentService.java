package m.kash.paymentservicek.services;

import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentService implements PaymentService{
    @Override
    public String doPayment(String email, String phoneno, Long amount, String orderID) {
        return null;
    }
}
