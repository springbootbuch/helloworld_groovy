package de.springbootbuch.helloworld

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Application {
    
    @RestController
    static class HelloWorldController {
        @GetMapping("/hello")
        String helloWorld(
            @RequestParam final String name
        ) {
            return "Hello, " + name + "\n"
        }
    }
    
    static void main(args) {
        SpringApplication.run Application, args
    }
}