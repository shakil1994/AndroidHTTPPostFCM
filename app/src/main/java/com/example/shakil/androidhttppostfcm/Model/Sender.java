package com.example.shakil.androidhttppostfcm.Model;

/**
 * Created by Shakil on 2/7/2018.
 */

public class Sender {
    public Notification notification;
    public String to;

    public Sender() {
    }

    public Sender(String to, Notification notification) {
        this.notification = notification;
        this.to = to;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}