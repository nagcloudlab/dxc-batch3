package com.example.web.dto;

import lombok.Data;

@Data
public class TransferRequestDto {
    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;
}
