package com.example.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gregory Green
 */
@RestController
public class HelloWorldController
{
    @GetMapping("/")
    public String hello()
    {
        return "Hello World";
    }
}
