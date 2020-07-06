package au.com.medaforum.twilioSms.sms.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("twilio")
public class TwilioConfigurer {

    private String accountSid;
    private String authToken;
    private String trial_number;

    public TwilioConfigurer() {}

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTrial_number() {
        return trial_number;
    }

    public void setTrial_number(String trial_number) {
        this.trial_number = trial_number;
    }

    @Override
    public String toString() {
        return "TwilioConfigurer{" +
                "accountSid='" + accountSid + '\'' +
                ", authToken='" + authToken + '\'' +
                ", trial_number='" + trial_number + '\'' +
                '}';
    }
}
