package com.tracker.demo.DTO;

import com.tracker.demo.DTO.ErrorDetailsDTO;

public class ApiResponse<T> {
    private int status;
    private T data;
    private String errorCode;

    public ApiResponse(int status, T data, String errorCode) {
        this.status = status;
        this.data = data;
        this.errorCode = errorCode;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, data, null);
    }
    public static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(201, data, null);
    }

    public static ApiResponse<ErrorDetailsDTO> error(int status, String errorCode, String message) {
        return new ApiResponse<>(status, new ErrorDetailsDTO(message), errorCode);
    }

    // Getter/Setter for Status code

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    // Getter/Setter for Data

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // Getter/Setter for errorCode

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}