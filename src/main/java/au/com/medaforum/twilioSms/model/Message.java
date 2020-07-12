package au.com.medaforum.twilioSms.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message {
    @SerializedName(value = "Type")
    private String type;
    @SerializedName(value = "MessageId")
    private String messageId;
    @SerializedName(value = "Subject")
    private String subject;
    @SerializedName(value = "Timestamp")
    private String timestamp;
    @SerializedName(value = "Message")
    private String message;
}

