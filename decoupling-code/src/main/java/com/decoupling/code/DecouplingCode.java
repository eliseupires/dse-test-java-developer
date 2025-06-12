package com.decoupling.code;

import com.decoupling.code.adapter.SendCompanyEmailAdapter;
import com.decoupling.code.adapter.SendCompanyEmailClient;
import com.decoupling.code.adapter.SendPersonalEmailAdapter;
import com.decoupling.code.adapter.SendPersonalEmailClient;
import com.decoupling.code.service.EmailNotifier;
import com.decoupling.code.service.IEmailService;

public class DecouplingCode {
    public static void main(String[] args) {
        SendCompanyEmailClient sendCompanyEmailClient = new SendCompanyEmailClient();
        IEmailService emailService = new SendCompanyEmailAdapter(sendCompanyEmailClient);
        EmailNotifier companyNotifier = new EmailNotifier(emailService);

        SendPersonalEmailClient sendPersonalEmailClient = new SendPersonalEmailClient();
        IEmailService personalEmailAdapter = new SendPersonalEmailAdapter(sendPersonalEmailClient);
        EmailNotifier personalNotifier = new EmailNotifier(personalEmailAdapter);

        companyNotifier.notifyUser("user@example.com", "Welcome!");
        personalNotifier.notifyUser("user@example.com", "Welcome!");
    }


}
