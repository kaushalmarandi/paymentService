package m.kash.paymentservicek.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentrequestdto {
    private String email;
    private String phoneNo;
    private Long amount;
    private String orderid;


}
