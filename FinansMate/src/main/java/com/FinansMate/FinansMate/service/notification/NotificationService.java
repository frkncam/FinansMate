package com.FinansMate.FinansMate.service.notification;

import com.FinansMate.FinansMate.dto.notification.NotificationRequest;
import com.FinansMate.FinansMate.dto.notification.NotificationResponse;

import java.util.List;

public interface NotificationService {
    void createNotification(NotificationRequest request);
    List<NotificationResponse> getUserNotifications(String username);
}
