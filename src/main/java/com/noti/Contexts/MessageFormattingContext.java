package com.noti.FormatorContext;

import com.noti.NotificationFormatStrategy.FormattingStrategy;

public class MessageFormattingContext {
    private FormattingStrategy strategy;

    public MessageFormattingContext(FormattingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(FormattingStrategy strategy) {
        this.strategy = strategy;
    }

    public String format(String message) {
        return this.strategy.format(message);
    } 
}
