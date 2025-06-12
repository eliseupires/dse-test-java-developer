package com.decoupling.code;

import com.decoupling.code.service.EmailNotifier;
import com.decoupling.code.service.IEmailService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class EmailNotifierTest {

    @Test
    public void testNotifyUser() {
        IEmailService mockEmailService = mock(IEmailService.class);
        EmailNotifier notifier = new EmailNotifier(mockEmailService);

        notifier.notifyUser("test@example.com", "Hello!");

        verify(mockEmailService).sendEmail("test@example.com", "Notification", "Hello!");
    }
}
