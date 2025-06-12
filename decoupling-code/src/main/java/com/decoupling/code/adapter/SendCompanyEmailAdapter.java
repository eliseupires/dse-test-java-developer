package com.decoupling.code.adapter;

import com.decoupling.code.service.IEmailService;

public class SendCompanyEmailAdapter implements IEmailService {
    private final SendCompanyEmailClient sendCompanyEmailClient;

    public SendCompanyEmailAdapter(SendCompanyEmailClient sendGridClient) {
        this.sendCompanyEmailClient = sendGridClient;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        sendCompanyEmailClient.send(to, subject, body);
    }
}
