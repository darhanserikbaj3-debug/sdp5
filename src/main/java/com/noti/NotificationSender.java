package com.noti;

public class NotificationSender {

    public void send(String type, String recipient, String message) {
        if ("SMS".equalsIgnoreCase(type)) {
            System.out.println("Conecting to SMS-tube");
            System.out.println("Sending message to number: " + recipient);
            System.out.println("Text of message: " + message);
            System.out.println("SMS sent!\n");
        } else if ("Telegram".equalsIgnoreCase(type)) {
            System.out.println("Connecting to Tg Bot API...");
            System.out.println("Sending message to: " + recipient);
            System.out.println("Text of the message: " + message);
            System.out.println("Message sent!\n");
        } else if ("Email".equalsIgnoreCase(type)) {
            System.out.println("Connectnig to server...");
            System.out.println("Forming message for: " + recipient);
            System.out.println("Text of message: " + message);
            System.out.println("Email sent!\n");
        } else {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}