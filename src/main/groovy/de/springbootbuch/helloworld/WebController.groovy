package de.springbootbuch.helloworld

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WebController {
    static class Person {
        String name
    }
    
    @GetMapping("/people")
    def people() {
        [listOfPeople: [
            new Person(name: "Ada Lovelace"),
            new Person(name: "Fran Allen"),
            new Person(name: "Grace Hopper"),
        ]]
    }
}