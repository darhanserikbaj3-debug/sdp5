package com.noti; 

import com.noti.ContextSender.NotificationSenderContext;
import com.noti.FormatorContext.MessageFormattingContext;
import com.noti.Selector.NotificationSelector;
import com.noti.NotificationFormatStrategy.FormattingStrategy;
import com.noti.NotificationSendStrategies.NotificationStrategy;
import com.noti.ConcreteFormators.PlainTextFormating;

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


        System.out.println("=== 3. DEMO: Runtime switching & Major-Client Selector choice ===");
        boolean isUrgent2 = false;
        boolean isMajor2 = true;

        formattingContext.setStrategy(NotificationSelector.selectFormator(isMajor2));
        senderContext.setStrategy(NotificationSelector.selectSender(isUrgent2, isMajor2));

        String formattedMsg2 = formattingContext.format(baseMessage);
        senderContext.send("telegram_bot1", formattedMsg2);
    }
}