package com.decoupling.code.service;

@FunctionalInterface
public interface IEmailService {
    void sendEmail(String to, String subject, String body);
}
