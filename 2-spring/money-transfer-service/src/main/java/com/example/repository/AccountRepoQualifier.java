package com.example.repository;


import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({
        java.lang.annotation.ElementType.TYPE,
        java.lang.annotation.ElementType.METHOD,
        ElementType.PARAMETER
})
@Qualifier
public @interface AccountRepoQualifier {

    String database();
    String tech();

}
