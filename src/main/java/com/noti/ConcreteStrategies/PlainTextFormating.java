package com.noti.ConcreteFormators;

import com.noti.NotificationFormatStrategy.FormattingStrategy;

public class PlainTextFormating implements FormattingStrategy {
    public String format(String message) {
        System.out.println("Applying formatting: Plain text");
        return message;
    }
}

