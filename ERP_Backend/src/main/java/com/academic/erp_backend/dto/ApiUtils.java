package com.academic.erp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiUtils<T> {
    private boolean success; // Indicates if the API request was successful
    private String message;  // Message providing additional information
    private T data;          // Generic data field for response payload
    private Object errors;   // Optional field to include error details
    private int statusCode;      // HTTP status code
}