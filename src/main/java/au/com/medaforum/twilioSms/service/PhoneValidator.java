package au.com.medaforum.twilioSms.service;

import com.twilio.rest.lookups.v1.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PhoneValidator {

    public boolean test(String phone) {
        try {
            PhoneNumber phoneNumber = PhoneNumber.fetcher(
                new com.twilio.type.PhoneNumber(phone))
                .fetch();
            log.info("phone number is {}" ,phoneNumber.getNationalFormat());
            return true;
        } catch (Exception e){
            return false;
        }

    }
}
