package m.kash.paymentservicek.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/razorpayWebHook")
public class RazorPayWebHookController {
    @PostMapping
    public ResponseEntity acceptWebhookRequest() {
          //redirecting to url
          return null;
      }

}
