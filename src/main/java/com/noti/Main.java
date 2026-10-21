package com.noti; 

import com.noti.ConcreteStrategies.PlainTextFormating;
import com.noti.Contexts.MessageFormattingContext;
import com.noti.Contexts.NotificationSenderContext;
import com.noti.Selector.NotificationSelector;
import com.noti.Strategies.FormattingStrategy;
import com.noti.Strategies.NotificationStrategy;

public class Main {
    public static void main(String[] args) {
        String baseMessage = "Order №45892 is sending!";

        System.out.println("=== Processing the same input by ALL formatting strategies ===");
        MessageFormattingContext formattingContext = new MessageFormattingContext(new PlainTextFormating());
        
        System.out.println("Plain: " + formattingContext.format(baseMessage));
        
        formattingContext.setStrategy(NotificationSelector.selectFormator(false));
        System.out.println("Markdown: " + formattingContext.format(baseMessage));
        
        formattingContext.setStrategy(NotificationSelector.selectFormator(true)); 
        System.out.println("HTML: " + formattingContext.format(baseMessage));


        System.out.println("\n=== Automatic choice by Selector  ===");
        boolean isUrgent1 = true;
        boolean isMajor1 = false;

        FormattingStrategy formatter1 = NotificationSelector.selectFormator(isMajor1);
        NotificationStrategy sender1 = NotificationSelector.selectSender(isUrgent1, isMajor1);

        formattingContext.setStrategy(formatter1);
        NotificationSenderContext senderContext = new NotificationSenderContext(sender1);

        String formattedMsg1 = formattingContext.format(baseMessage);
        senderContext.send("+77070000000", formattedMsg1);
    }
}