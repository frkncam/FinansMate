package com.FinansMate.FinansMate.mapper;

import com.FinansMate.FinansMate.dto.notification.NotificationRequest;
import com.FinansMate.FinansMate.dto.notification.NotificationResponse;
import com.FinansMate.FinansMate.model.MyUser;
import com.FinansMate.FinansMate.model.Notification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificationMapper {

    public Notification toEntity(NotificationRequest request, MyUser user) {
        Notification notification = new Notification();
        notification.setMessage(request.getMessage());
        notification.setRead(request.isRead());
        notification.setUser(user);
        notification.setCreatedAt(LocalDateTime.now());
        return notification;
    }

    public NotificationResponse toResponse(Notification notification) {
        NotificationResponse response = new NotificationResponse();
        response.setId(notification.getId());
        response.setMessage(notification.getMessage());
        response.setRead(notification.isRead());
        response.setCreatedAt(notification.getCreatedAt());
        response.setUsername(notification.getUser().getUsername());
        return response;
    }
}s
