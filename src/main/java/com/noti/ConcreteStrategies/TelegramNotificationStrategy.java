package com.noti.ConcreteSenders;

import com.noti.NotificationSendStrategies.NotificationStrategy;

public class TelegramNotificationStrategy implements NotificationStrategy{
    @Override 
    public void sendMessage(String recepient, String message) {
        System.out.println("Connecting to Tg Bot API...");
        System.out.println("Sending message to: " + recepient);
        System.out.println("Text of the message: " + message);
        System.out.println("Message sent!\n");
    }
}
