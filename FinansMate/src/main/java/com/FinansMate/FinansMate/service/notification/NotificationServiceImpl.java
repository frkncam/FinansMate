package com.FinansMate.FinansMate.service.notification;

import com.FinansMate.FinansMate.dto.notification.NotificationRequest;
import com.FinansMate.FinansMate.dto.notification.NotificationResponse;
import com.FinansMate.FinansMate.mapper.NotificationMapper;
import com.FinansMate.FinansMate.model.MyUser;
import com.FinansMate.FinansMate.model.Notification;
import com.FinansMate.FinansMate.repository.NotificationRepository;
import com.FinansMate.FinansMate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public void createNotification(NotificationRequest request) {
        MyUser user = userRepository.findById(request.getUserId()).orElse(null);
        if (user == null) {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }

        Notification notification = notificationMapper.toEntity(request, user);
        notificationRepository.save(notification);
    }

    @Override
    public List<NotificationResponse> getUserNotifications(String username) {
        MyUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }

        return notificationRepository.findByUserId(user.getId())
                .stream()
                .map(notificationMapper::toResponse)
                .toList();
    }
}