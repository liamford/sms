package au.com.medaforum.twilioSms.service;

import au.com.medaforum.twilioSms.model.SmsRequest;

public interface SmsServiceProviders {

    void sendSMS(SmsRequest smsRequest);
}
