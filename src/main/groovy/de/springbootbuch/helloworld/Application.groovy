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
        def helloWorld(@RequestParam name) {
            """
            Hello $name,
            how are you?
            """.stripIndent().trim()
        }
    }
    
    static void main(args) {
        SpringApplication.run Application, args
    }
}