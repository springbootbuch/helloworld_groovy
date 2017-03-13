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

        class Response {
            String greeting
        }

        @GetMapping("/hello")
        def helloWorld(
            @RequestParam name
        ) {
            new Response(
                greeting: "Hello $name"
            )
        }
    }
    
    static void main(args) {
        SpringApplication.run Application, args
    }
}