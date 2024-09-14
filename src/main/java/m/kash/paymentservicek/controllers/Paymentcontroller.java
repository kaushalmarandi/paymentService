package m.kash.paymentservicek.controllers;

import com.razorpay.RazorpayException;
import m.kash.paymentservicek.Dtos.InitiatePaymentrequestdto;
import m.kash.paymentservicek.services.PaymentService;
import m.kash.paymentservicek.strategy.PaymentGatewaySelection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class Paymentcontroller {

    private PaymentService razorPayPaymentService;
    private PaymentService stripePaymentService;
    private PaymentGatewaySelection paymentGatewaySelection;

    public Paymentcontroller(@Qualifier("razorpay") PaymentService razorPayPaymentService,
                             @Qualifier("stripe") PaymentService stripePaymentService,
                             PaymentGatewaySelection paymentGatewaySelection){
        this.razorPayPaymentService=razorPayPaymentService;
        this.stripePaymentService=stripePaymentService;
        this.paymentGatewaySelection=paymentGatewaySelection;
    }

    @PostMapping("/payment")
    public String initiatePayment(@RequestBody InitiatePaymentrequestdto requestDto) throws JSONException, RazorpayException {
        //which payment gateway to use
        int paymentGatewayOption = choosePaymentGateway();
        switch (paymentGatewayOption) {

            case 1:
            return razorPayPaymentService.doPayment(requestDto.getEmail(),
                requestDto.getPhoneNo(),
                requestDto.getAmount(),
                requestDto.getOrderid());

            case 2:
                return stripePaymentService.doPayment(requestDto.getEmail(),
                        requestDto.getPhoneNo(),
                        requestDto.getAmount(),
                        requestDto.getOrderid());
       }
       return null;
    }


    private int choosePaymentGateway(){
        return paymentGatewaySelection.choosePaymentGateway();
    }
}
