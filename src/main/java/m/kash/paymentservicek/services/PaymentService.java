package m.kash.paymentservicek.services;

import com.razorpay.RazorpayException;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;


public interface PaymentService {
    String doPayment(String email,
                     String phoneno,
                     Long amount,
                     String orderID) throws JSONException, RazorpayException;
}
