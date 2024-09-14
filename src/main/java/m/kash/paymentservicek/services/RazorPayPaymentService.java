package m.kash.paymentservicek.services;

import com.razorpay.Order;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.boot.configurationprocessor.json.JSONException;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpay")
public class RazorPayPaymentService implements PaymentService{

    private RazorpayClient razorpayClient;

    public RazorPayPaymentService(RazorpayClient razorpayClient){
        this.razorpayClient=razorpayClient;
    }
    @Override
    public String doPayment(String email, String phoneno, Long amount, String orderID) throws JSONException, RazorpayException {
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",50000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("receipt", "orderId");

        JSONObject customer =new JSONObject();
        customer.put("email", email);
        customer.put("phone", phoneno);
        paymentLinkRequest.put("customer", customer);

        JSONObject notify= new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);

        paymentLinkRequest.put("callback_url", "https://xyz.com/razorWebHook");
        paymentLinkRequest.put("callback_method", "post");

      //  Order order = instance.orders.create(paymentLinkRequest);;

        PaymentLink response = razorpayClient.paymentLink.create(paymentLinkRequest);
        return response.toString();
    }

}
