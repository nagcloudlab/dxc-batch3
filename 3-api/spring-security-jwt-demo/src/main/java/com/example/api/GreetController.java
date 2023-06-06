package com.example.api;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/greet")
public class GreetController {

    @GetMapping
    public String doGreet(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication.getPrincipal());
//        authentication.getAuthorities().forEach(System.out::println);
        return "hello, from secure endpoint";
    }

}
