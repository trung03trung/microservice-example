package com.example.productservice.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductException extends RuntimeException {
    private BaseMessage error;
    private String errorCode;

    public ProductException() {
    }

    public ProductException(String message) {
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
    public ProductException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    public ProductException(BaseMessage error) {
        super(error.getDesc());
        this.error = error;
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductException(Throwable cause) {
        super(cause);
    }

    public ProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProductException(ApiResponse<?> response) {
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
