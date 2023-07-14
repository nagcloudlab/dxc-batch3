package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitController {

    @Autowired
    RedisTemplate<String, Integer> redisTemplate;
;

    @GetMapping("/visit")
    public String visit() {
        ValueOperations<String, Integer> valueOperations = redisTemplate.opsForValue();
        Integer count = valueOperations.get("visit:count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        valueOperations.set("visit:count", count);
        System.out.println(count);
        return "Visit-count: " + count + " times";
    }

}
