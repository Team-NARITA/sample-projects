package com.teamnarita.sample.sampleserver

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping(value = ["/"])
    fun hello(): String {
        return "hello world"
    }
}