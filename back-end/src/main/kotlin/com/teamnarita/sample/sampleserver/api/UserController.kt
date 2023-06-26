package com.teamnarita.sample.sampleserver.api

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/users")
class UserController {

    @PostMapping("/")
    fun createUser() {

    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable("userId") userId: String): String {
        return SecurityContextHolder.getContext().authentication.principal.toString()
        //return userId
    }
}

