package au.com.medaforum.twilioSms.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;


@Component
@Slf4j
public class NotificationReceiver {

    @JmsListener(destination = "${amazon.sqs}")
    public void receive(String json) throws JMSException {
        log.info("Result received: {}", json);
    }
}
