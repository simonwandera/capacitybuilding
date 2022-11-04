package com.capacitybuilding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification extends BaseEntity{

    @Column(name = "message")
    String message;

    @Column(name = "status")
    String status;

    public Notification() {
    }

    public Notification(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
