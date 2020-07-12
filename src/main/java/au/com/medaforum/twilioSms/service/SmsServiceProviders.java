package au.com.medaforum.twilioSms.service;

import au.com.medaforum.twilioSms.model.Notification;

public interface SmsServiceProviders {

    void sendSMS(Notification notification);
}
