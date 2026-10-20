package com.noti;

public class Main {
    public static void main(String[] args) {
        NotificationSender sender = new NotificationSender();
        String message = "Order №45892 is sending!";

        System.out.println("=== Testing monolithic sender ===");
        
        sender.send("SMS", "+79990001122", message);
        sender.send("Telegram", "telegram_chat_id_999", message);
        sender.send("Email", "user@example.com", message);
    }
}