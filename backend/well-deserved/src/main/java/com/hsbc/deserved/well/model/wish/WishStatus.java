package com.hsbc.deserved.well.model.wish;

public enum WishStatus {
    ADDED("ADDED"), PRICED("PRICED"), WAITING_TO_BUY("WAITING TO BUY"), BOUGHT("BOUGHT");

    private String value;

    private WishStatus(String value) {
        this.value = value;
    }

    public static WishStatus value(String value) {
        for (WishStatus r : WishStatus.values()) {
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