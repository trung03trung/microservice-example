package com.example.productservice.utils;

public enum ErrorMessage implements BaseMessage {
    SYSTEM_ERROR("001","System errors"),
    ;

    private final String code;
    private String desc;
    private String descFormat;

    ErrorMessage(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    ErrorMessage(String code, String desc, String descFormat) {
        this.code = code;
        this.desc = desc;
        this.descFormat = descFormat;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    public ErrorMessage format(Object... str) {
        if (this.descFormat != null) {
            this.desc = String.format(this.descFormat, str);
        }
        return this;
    }
}
