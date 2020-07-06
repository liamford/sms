package au.com.medaforum.twilioSms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SmsRequest {

    @NotBlank private final String phoneNumber;
    @NotBlank private final String content;

    public SmsRequest(
            @JsonProperty("phoneNumber")
            String phoneNumber,
            @JsonProperty("content")
            String content) {
        this.phoneNumber = phoneNumber;
        this.content = content;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
