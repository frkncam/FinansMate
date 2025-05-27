package com.FinansMate.FinansMate.controller.notification;

import com.FinansMate.FinansMate.dto.notification.NotificationRequest;
import com.FinansMate.FinansMate.dto.notification.NotificationResponse;
import com.FinansMate.FinansMate.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void createNotification(@RequestBody NotificationRequest request) {
        notificationService.createNotification(request);
    }

    @GetMapping("/{username}")
    public List<NotificationResponse> getUserNotifications(@PathVariable String username) {
        return notificationService.getUserNotifications(username);
    }
}
