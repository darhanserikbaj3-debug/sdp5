package com.noti.ConcreteSenders;

import com.noti.ExternalData.SimulatedTrafficService;
import com.noti.ExternalData.TrafficService;
import com.noti.NotificationSendStrategies.NotificationStrategy;

public class SMSNotificationStrategy implements NotificationStrategy {
    private final TrafficService trafficService;

    public SMSNotificationStrategy() {
        this.trafficService = new SimulatedTrafficService();
    }
    public SMSNotificationStrategy(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @Override 
    public void sendMessage(String recipient, String message) {
        String traffic = trafficService != null ? trafficService.getTrafficCondition() : "Normal";
        System.out.println("Conecting to SMS-tube");
        System.out.println("Sending message to number: " + recipient);
        System.out.println("Text: " + message + " | Current traffic" + traffic);
        System.out.println("SMS sent!\n");
    }
}
