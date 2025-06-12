package com.decoupling.code.adapter;

import com.decoupling.code.service.IEmailService;

public class SendPersonalEmailAdapter implements IEmailService {
    private final SendPersonalEmailClient sendPersonalEmailClient;

    public SendPersonalEmailAdapter(SendPersonalEmailClient sendGridClient) {
        this.sendPersonalEmailClient = sendGridClient;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        sendPersonalEmailClient.send(to, subject, body);
    }
}
