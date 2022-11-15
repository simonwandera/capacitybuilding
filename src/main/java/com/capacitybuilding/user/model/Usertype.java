package com.capacitybuilding.user.model;

public enum Usertype {
    USER("USER"),
    TRAINER("TRAINER"),
    ADMIN("ADMIN");

    private String userType;

    Usertype(String userType) {
       this.userType = userType;
    }
}
