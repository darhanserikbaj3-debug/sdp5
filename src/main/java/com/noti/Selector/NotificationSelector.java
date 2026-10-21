package com.noti.Selector;

import com.noti.ConcreteFormators.HtmlFormatting;
import com.noti.ConcreteFormators.MarkdownFormatting;
import com.noti.ConcreteFormators.PlainTextFormating;
import com.noti.ConcreteSenders.EmailNotificationStrategy;
import com.noti.ConcreteSenders.SMSNotificationStrategy;
import com.noti.ConcreteSenders.TelegramNotificationStrategy;
import com.noti.NotificationFormatStrategy.FormattingStrategy;
import com.noti.NotificationSendStrategies.NotificationStrategy;

public class NotificationSelector {
    public static NotificationStrategy selectSender(boolean isUrgent, boolean isMajor) {
        if (isUrgent) {
            return new SMSNotificationStrategy();
        } else if (isMajor) {
            return new TelegramNotificationStrategy();
        } else {
            return new EmailNotificationStrategy();
        }
    }

    public static FormattingStrategy selectFormator(boolean isMajor) {
        if (isMajor) {
            return new HtmlFormatting();
        } else {
            return new MarkdownFormatting();
        }
    }

    public static FormattingStrategy selectFormator() {
        return new PlainTextFormating();
    }
}
