package com.example.productservice.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private String code;
    private String desc;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(String code) {
        this.code = code;
    }

    public ApiResponse(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public ApiResponse(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public ApiResponse(String code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<T>(BaseMessage.CODE_SUCCESS, BaseMessage.DESC_SUCCESS);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(BaseMessage.CODE_SUCCESS, BaseMessage.DESC_SUCCESS, data);
    }

    public static <T> ApiResponse<T> error(BaseMessage error) {
        return new ApiResponse<T>(error.getCode(), error.getDesc());
    }

    public static <T> ApiResponse<T> error(BaseMessage error, T data) {
        return new ApiResponse<T>(error.getCode(), error.getDesc(), data);
    }
}
