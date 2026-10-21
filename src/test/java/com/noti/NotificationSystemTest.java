package com.noti;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import com.noti.ConcreteStrategies.EmailNotificationStrategy;
import com.noti.ConcreteStrategies.HtmlFormatting;
import com.noti.ConcreteStrategies.MarkdownFormatting;
import com.noti.ConcreteStrategies.PlainTextFormating;
import com.noti.ConcreteStrategies.SMSNotificationStrategy;
import com.noti.Selector.NotificationSelector;
import com.noti.Strategies.FormattingStrategy;
import com.noti.Strategies.NotificationStrategy;

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

    @Test
    public void testSmsStrategyWithFakeTrafficService() {
        com.noti.ExternalData.TrafficService fakeTraffic = new com.noti.ExternalData.FakeTrafficService();
        SMSNotificationStrategy smsStrategy = new SMSNotificationStrategy(fakeTraffic);
        assertNotNull(smsStrategy);
    }
}