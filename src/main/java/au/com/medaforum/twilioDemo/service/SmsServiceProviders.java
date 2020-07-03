package au.com.medaforum.twilioDemo.service;

import au.com.medaforum.twilioDemo.model.SmsRequest;

public interface SmsServiceProviders {

    void sendSMS(SmsRequest smsRequest);
}
