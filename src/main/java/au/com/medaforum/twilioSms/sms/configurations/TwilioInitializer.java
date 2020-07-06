package au.com.medaforum.twilioSms.sms.configurations;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger("TwilioInitializer.class");
    TwilioConfigurer twilioConfigurer ;

    @Autowired
    public TwilioInitializer(TwilioConfigurer twilioConfigurer){
        this.twilioConfigurer = twilioConfigurer ;
        String acctSid = twilioConfigurer.getAccountSid() ;
        String authToken = twilioConfigurer.getAuthToken() ;
        Twilio.init(acctSid,authToken);
        LOGGER.info("Twilio initialized");
    }

}
