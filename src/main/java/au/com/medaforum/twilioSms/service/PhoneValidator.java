package au.com.medaforum.twilioSms.service;

import com.twilio.rest.lookups.v1.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PhoneValidator {

    public boolean validate(String phone) {
        log.info("validating phone number = {}", phone);
        try {
            PhoneNumber phoneNumber = PhoneNumber.fetcher(
                new com.twilio.type.PhoneNumber(phone))
                .fetch();
            log.info("phone validated successfully {}", phoneNumber);
            return true;
        } catch (Exception e) {
            log.error("phone validation failed {}", phone, e);
            return false;
        }
    }
}
