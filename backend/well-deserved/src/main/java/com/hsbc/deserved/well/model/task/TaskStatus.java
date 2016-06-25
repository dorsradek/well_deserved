package com.hsbc.deserved.well.model.task;

public enum TaskStatus {
    TODO("TO DO"), DONE("DONE"), VERIFIED("VERIFIED");

    private String value;

    private TaskStatus(String value) {
        this.value = value;
    }

    public static TaskStatus value(String value) {
        for (TaskStatus r : TaskStatus.values()) {
            if (r.getValue().equals(value)) {
                return r;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }


}