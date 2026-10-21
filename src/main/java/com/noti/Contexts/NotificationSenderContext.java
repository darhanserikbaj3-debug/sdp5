package com.noti.ContextSender;

import com.noti.NotificationSendStrategies.NotificationStrategy;

public class NotificationSenderContext {
    private NotificationStrategy strategy;

    public NotificationSenderContext(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void send(String recepient, String message) {
        this.strategy.sendMessage(recepient, message);
    }
}
