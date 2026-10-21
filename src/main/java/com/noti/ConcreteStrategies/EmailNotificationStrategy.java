package com.noti.ConcreteSenders;

import com.noti.NotificationSendStrategies.NotificationStrategy;

public class EmailNotificationStrategy implements NotificationStrategy{
    @Override 
    public void sendMessage(String recepient, String message) {
        System.out.println("Connectnig to server...");
        System.out.println("Forming message for: " + recepient);
        System.out.println("Text of message: " + message);
        System.out.println("Email sent!\n");
    }
}
