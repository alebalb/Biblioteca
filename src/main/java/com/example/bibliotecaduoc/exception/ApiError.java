package com.example.bibliotecaduoc.exception;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private int status;
    private String message;
}
