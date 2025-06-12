package com.decoupling.code.service;

public class EmailNotifier {
    private final IEmailService emailService;

    public EmailNotifier(IEmailService emailService) {
        this.emailService = emailService;
    }

    public void notifyUser(String email, String message) {
        emailService.sendEmail(email, "Notification", message);
    }
}
