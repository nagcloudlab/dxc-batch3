package org.example.dxc;


import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnMissingBean(name = "dxc")
@ConditionalOnProperty(name = "dxc.enabled", havingValue = "true")
public class DxcAutoConfiguration {


    @Bean
    public String dxc(){
        return "dxc-india";
    }

}
