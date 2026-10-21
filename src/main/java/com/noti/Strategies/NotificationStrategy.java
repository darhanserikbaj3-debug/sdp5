package com.noti.NotificationSendStrategies;
public interface NotificationStrategy {
    void sendMessage(String recepient, String message);
}