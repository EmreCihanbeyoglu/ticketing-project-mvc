package com.cydeo.enums;

public enum ProjectStatus {
    NOT_STARTED("Not started"), ONGOING("Ongoing"), FINISHED("Finished");

    private final String value;

    private ProjectStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
