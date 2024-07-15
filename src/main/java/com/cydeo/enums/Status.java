package com.cydeo.enums;

public enum Status {
    NOT_STARTED("Not started"), ONGOING("Ongoing"), FINISHED("Finished");

    private final String value;

    private Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
