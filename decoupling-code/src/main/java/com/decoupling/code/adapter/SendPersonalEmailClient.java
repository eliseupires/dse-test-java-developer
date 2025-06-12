package com.decoupling.code.adapter;

public class SendPersonalEmailClient {
    public void send(String recipient, String title, String content) {
        System.out.println("[Personal] Email sent to: " + recipient);
    }
}
