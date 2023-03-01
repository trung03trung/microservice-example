package com.example.inventoryservice.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRuntimeException extends RuntimeException {
    private BaseMessage error;
    private String errorCode;

    public OrderRuntimeException() {
    }

    public OrderRuntimeException(String message) {
        super(message);
        this.error = new BaseMessage() {
            @Override
            public String getCode() {
                return "0001";
            }

            @Override
            public String getDesc() {
                return "Unhandled error";
            }

            @Override
            public ErrorMessage format(Object... str) {
                return null;
            }
        };
    }
    public OrderRuntimeException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    public OrderRuntimeException(BaseMessage error) {
        super(error.getDesc());
        this.error = error;
    }

    public OrderRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderRuntimeException(Throwable cause) {
        super(cause);
    }

    public OrderRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public OrderRuntimeException(ApiResponse<?> response) {
        super(response.getDesc());
        this.error = new BaseMessage() {
            @Override
            public String getCode() {
                return response.getCode();
            }

            @Override
            public String getDesc() {
                return response.getDesc();
            }

            @Override
            public ErrorMessage format(Object... str) {
                return null;
            }
        };
    }
}
