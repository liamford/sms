package au.com.medaforum.twilioSms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Getter
@AllArgsConstructor
public enum NotificationStatus {
    QUESTION(0, "Question"),
    MORE_INFO_REQUEST(1, "More Information"),
    MORE_INFO_ANSWERED(2, "More Information"),
    ANSWER(3, "Answer");
    private static final Map<Integer, String> NOTIFICATION_TYPE_MAP = new HashMap<Integer, String>(3);

    static {
        for (NotificationStatus status : NotificationStatus.values()) {
            NOTIFICATION_TYPE_MAP.put(status.getType(), status.naturalName);
        }
    }

    private final Integer type;
    private final String naturalName;

    public static Map<Integer, String> getNotificationTypeMap() {
        return Collections.unmodifiableMap(NOTIFICATION_TYPE_MAP);
    }


}
