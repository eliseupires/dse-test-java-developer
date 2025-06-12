package com.decoupling.code.adapter;

public class SendCompanyEmailClient {
    public void send(String recipient, String title, String content) {
        System.out.println("[Company] Email sent to: " + recipient);
    }
}
