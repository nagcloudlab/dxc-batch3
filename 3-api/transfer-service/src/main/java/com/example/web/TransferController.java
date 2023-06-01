package com.example.web;

import java.util.Collection;
import java.util.Random;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.TransferService;
import com.example.web.dto.TransferRequestDto;
import com.example.web.dto.TransferResponseDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;
    private final Random random = new Random();

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public ModelAndView doTransfer() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println(username);
        Collection<?> authorities = authentication.getAuthorities();
        authorities.forEach(System.out::println);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transfer-form");
        return modelAndView;
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ModelAndView doTransfer(
            // @RequestParam String fromAccountNumber,
            // @RequestParam String toAccountNumber,
            // @RequestParam Double amount
            @ModelAttribute TransferRequestDto transferRequestDto) {

        transferService.transfer(transferRequestDto.getFromAccountNumber(), transferRequestDto.getToAccountNumber(),
                transferRequestDto.getAmount());
        TransferResponseDto transferResponseDto = new TransferResponseDto();
        transferResponseDto.setTxnId(random.nextLong());
        transferResponseDto.setStatus("Transfer successful!");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("transferResponse", transferResponseDto);
        modelAndView.setViewName("transfer-status");
        return modelAndView;
    }

}
