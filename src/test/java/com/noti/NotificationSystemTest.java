package com.noti;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import com.noti.ConcreteFormators.HtmlFormatting;
import com.noti.ConcreteFormators.MarkdownFormatting;
import com.noti.ConcreteFormators.PlainTextFormating;
import com.noti.ConcreteSenders.EmailNotificationStrategy;
import com.noti.ConcreteSenders.SMSNotificationStrategy;
import com.noti.Selector.NotificationSelector;
import com.noti.NotificationFormatStrategy.FormattingStrategy;
import com.noti.NotificationSendStrategies.NotificationStrategy;

public class NotificationSystemTest {

    @Test
    public void testStrategyLogic() {
        FormattingStrategy formatter = new HtmlFormatting();
        assertEquals("<html><body><p>Test</p></body></html>", formatter.format("Test"));

        NotificationStrategy sender = new EmailNotificationStrategy();
        assertNotNull(sender);
    }

    @Test
    public void testSelectors() {
        NotificationStrategy urgentSender = NotificationSelector.selectSender(true, false);
        assertTrue(urgentSender instanceof SMSNotificationStrategy);

        FormattingStrategy majorFormatter = NotificationSelector.selectFormator(true);
        assertTrue(majorFormatter instanceof HtmlFormatting);
    }

    static Stream<FormattingStrategy> formattingStrategiesProvider() {
        return Stream.of(
            new HtmlFormatting(),
            new MarkdownFormatting(),
            new PlainTextFormating()
        );
    }

    @ParameterizedTest
    @MethodSource("formattingStrategiesProvider")
    public void testAllStrategiesParameterized(FormattingStrategy strategy) {
        assertNotNull(strategy.format("Hello"));
    }
}