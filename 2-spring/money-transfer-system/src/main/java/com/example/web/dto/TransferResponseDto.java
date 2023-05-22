package com.example.web.dto;

import lombok.Data;

@Data
public class TransferResponseDto {

    private Long txnId;
    private String status;
    private String message;

}
