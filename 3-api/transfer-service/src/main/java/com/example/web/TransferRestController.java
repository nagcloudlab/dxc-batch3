package com.example.web;

import com.example.service.TransferService;
import com.example.web.dto.TransferRequestDto;
import com.example.web.dto.TransferResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/transfer") // <1>
@RequiredArgsConstructor
public class TransferRestController {

    private final TransferService transferService;
    private final Random random = new Random();

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public TransferResponseDto doTransfer(
            @RequestBody TransferRequestDto transferRequestDto) {

        transferService.transfer(transferRequestDto.getFromAccountNumber(), transferRequestDto.getToAccountNumber(),
                transferRequestDto.getAmount());
        TransferResponseDto transferResponseDto = new TransferResponseDto();
        transferResponseDto.setTxnId(random.nextLong());
        transferResponseDto.setStatus("Transfer successful!");
        return transferResponseDto;
    }

}
