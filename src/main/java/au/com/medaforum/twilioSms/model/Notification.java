package au.com.medaforum.twilioSms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Notification {
    private String email;
    private String mobile;
    private NotificationType notificationType;
    private boolean emailNotification;
    private boolean smsNotification;
}

