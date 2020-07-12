package au.com.medaforum.twilioSms.listener;

import au.com.medaforum.twilioSms.model.Message;
import au.com.medaforum.twilioSms.model.Notification;
import au.com.medaforum.twilioSms.service.SmsServiceProviders;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.util.function.Function;
import java.util.function.Predicate;


@Component
@Slf4j
public class NotificationReceiver {

    private final SmsServiceProviders smsServiceProviders;

    public NotificationReceiver(SmsServiceProviders smsServiceProviders) {
        this.smsServiceProviders = smsServiceProviders;
    }

    @JmsListener(destination = "${amazon.sqs}")
    public void receive(String json) throws JMSException {
        log.info("Result received: {}", json);
        Notification notification = GET_NOTIFICATION.apply(json);
        if(smsEligible.test(notification)) {
            smsServiceProviders.sendSMS(notification);
        } else {
            log.info("SMS not selected for {} ",notification.getEmail());
        }

    }

    Predicate<Notification> smsEligible = notification -> notification.isSmsNotification();

    Function<String, Notification> GET_NOTIFICATION = (json) -> {
        Gson gson = new Gson();
        Message snsMessage = gson.fromJson(json, Message.class);
        return gson.fromJson(snsMessage.getMessage(), Notification.class);
    };

}
