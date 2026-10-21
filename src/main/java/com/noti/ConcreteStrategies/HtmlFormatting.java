package com.noti.ConcreteFormators;

import com.noti.NotificationFormatStrategy.FormattingStrategy;

public class HtmlFormatting implements FormattingStrategy {
    @Override 
    public String format(String message) {
        System.out.println("Applying formatting: Html-format");
        return "<html><body><p>" + message + "</p></body></html>";
    } 
    
}
