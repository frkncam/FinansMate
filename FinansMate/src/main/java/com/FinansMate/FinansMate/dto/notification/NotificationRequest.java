package com.FinansMate.FinansMate.dto.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {
    private String message;
    private boolean isRead;
    private Long userId;
}