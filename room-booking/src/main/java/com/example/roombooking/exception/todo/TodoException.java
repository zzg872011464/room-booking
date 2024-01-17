package com.example.roombooking.exception.todo;

import lombok.Data;

@Data
public class TodoException extends RuntimeException {
    private String msg;
}
