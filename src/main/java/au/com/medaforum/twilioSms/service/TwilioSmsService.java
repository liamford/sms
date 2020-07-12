package au.com.medaforum.twilioSms.service;

import au.com.medaforum.twilioSms.model.Notification;
import au.com.medaforum.twilioSms.sms.configurations.TwilioConfigurer;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class TwilioSmsService implements SmsServiceProviders {


    private final TwilioConfigurer twilioConfigurer;

    @Autowired
    public TwilioSmsService(TwilioConfigurer twilioConfigurer) {
        this.twilioConfigurer = twilioConfigurer;
    }

    @Override
    public void sendSMS(Notification smsRequest) {
        log.info("Sending sms for {}", smsRequest);
        try {

            PhoneNumber sender = new PhoneNumber(twilioConfigurer.getTrial_number());
            PhoneNumber recipient = new PhoneNumber(smsRequest.getMobile());
            if (!isPhoneNumberValid(recipient)) {
                String smsBody = "Your question has been received";
                Message.creator(recipient, sender, smsBody).create();
                log.info("sms has been sent successfully to {}", smsRequest);
            } else {
                log.error("Phone Number: " + recipient + " is not valid");
            }
        } catch (Exception e) {
            log.error("Problem in sending sms for {}", smsRequest, e);
        }

    }

    private boolean isPhoneNumberValid(PhoneNumber recipient) {
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(recipient.toString());
        return (m.find() && m.group().equals(recipient));

    }
}
