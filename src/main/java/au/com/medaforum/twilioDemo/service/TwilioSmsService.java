package au.com.medaforum.twilioDemo.service;

import au.com.medaforum.twilioDemo.sms.configurations.TwilioConfigurer;
import au.com.medaforum.twilioDemo.model.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TwilioSmsService implements SmsServiceProviders{


    private final TwilioConfigurer twilioConfigurer;

    @Autowired
    public TwilioSmsService(TwilioConfigurer twilioConfigurer){
        this.twilioConfigurer = twilioConfigurer;
    }

    @Override
    public void sendSMS(SmsRequest smsRequest) {
        PhoneNumber sender = new PhoneNumber(twilioConfigurer.getTrial_number());
        PhoneNumber recipient= new PhoneNumber(smsRequest.getPhoneNumber());
        if(!isPhoneNumberValid(recipient)){
            String smsBody = smsRequest.getContent();
            Message.creator(recipient,sender,smsBody).create();
        }
        else{
            throw new IllegalArgumentException("Phone Number: "+recipient+" is not valid");
        }

    }

    private boolean isPhoneNumberValid(PhoneNumber recipient) {
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(recipient.toString());
        return (m.find() && m.group().equals(recipient));

    }
}
