package com.example.EmployeeManagementSystem.Model;

import lombok.Data;

@Data
public class BaseResponse {

    private Object data;

    private String message;

    private Object code;
}
