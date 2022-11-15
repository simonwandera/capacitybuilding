package com.capacitybuilding.training.model;

public enum TrainingStatus {
    UPCOMING("UPCOMING"),
    ONGOING("ONGOING"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    private String status;

    TrainingStatus(String status) {
        this.status = status;
    }
}
