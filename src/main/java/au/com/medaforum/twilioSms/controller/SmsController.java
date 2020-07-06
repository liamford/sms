package au.com.medaforum.twilioSms.controller;

import au.com.medaforum.twilioSms.model.SmsRequest;
import au.com.medaforum.twilioSms.service.TwilioSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/sms")
public class SmsController {

    private final TwilioSmsService twilioSmsService;

    @Autowired
    public SmsController(TwilioSmsService twilioSmsService){
        this.twilioSmsService = twilioSmsService ;
    }

    @PostMapping()
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
        twilioSmsService.sendSMS(smsRequest);
    }
}
