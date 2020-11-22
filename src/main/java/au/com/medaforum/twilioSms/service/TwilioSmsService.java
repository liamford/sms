package au.com.medaforum.twilioSms.service;

import au.com.medaforum.twilioSms.model.Notification;
import au.com.medaforum.twilioSms.model.NotificationStatus;
import au.com.medaforum.twilioSms.sms.configurations.TwilioConfigurer;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TwilioSmsService implements SmsServiceProviders {


    private final TwilioConfigurer twilioConfigurer;
    private final PhoneValidator phoneValidator;

    @Value("${medaforum.url}")
    private String url;

    @Autowired
    public TwilioSmsService(TwilioConfigurer twilioConfigurer, PhoneValidator phoneValidator) {
        this.twilioConfigurer = twilioConfigurer;
        this.phoneValidator = phoneValidator;
    }

    @Override
    public void sendSMS(String questionId, Notification smsRequest) {
        log.info("Sending sms for {}", smsRequest);
        try {

            PhoneNumber sender = new PhoneNumber(twilioConfigurer.getPhone());
            PhoneNumber recipient = new PhoneNumber(smsRequest.getMobile());
            if (isPhoneNumberValid(recipient)) {
                String questionUrl = url + "/status/" + questionId;
                String smsBody = getMessageBody(questionUrl, smsRequest);
                Message.creator(recipient, sender, smsBody).create();
                log.info("sms has been sent successfully to {}", smsRequest);
            } else {
                log.error("Phone Number: " + recipient + " is not valid");
            }
        } catch (Exception e) {
            log.error("Problem in sending sms for {}", smsRequest, e);
        }

    }

    private String getMessageBody(String questionUrl, Notification smsRequest) {
        if (smsRequest.getNotificationType().getCode() == NotificationStatus.QUESTION.getType()) {
            return "Medaforum has received your question , you will be notified when the doctor answers your question.\n" +
                questionUrl;
        } else if (smsRequest.getNotificationType().getCode() == NotificationStatus.ANSWER.getType()) {
            return "Medaforum has answered your question ,please visit the below link.\n" +
                questionUrl;
        } else {
            return "Medaforum needs more information to answer your question ,for providing more information please visit the below link.\n" +
                questionUrl;
        }
    }

    private boolean isPhoneNumberValid(PhoneNumber recipient) {
        return phoneValidator.validate(recipient.getEndpoint());
    }
}
