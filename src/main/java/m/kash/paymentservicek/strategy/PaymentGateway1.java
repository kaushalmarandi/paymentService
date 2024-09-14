package m.kash.paymentservicek.strategy;

public class PaymentGateway1 implements PaymentGatewaySelection{
    @Override
    public int choosePaymentGateway() {
        //choose payment gateway logic
        //out of 10, 7 should go to r
        //Math.random(1-10) if(val<=7) return 1 else 2
        return 0;
    }
}
