package com.eheinen.kotlinreactive.api

import com.eheinen.kotlinreactive.api.ApiResources.HELLO_WORLD
import com.eheinen.kotlinreactive.api.ApiVersions.VERSION_1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping(VERSION_1 + HELLO_WORLD)
    fun showHelloWorld(): String {
        return "{ \"message\": \"Hello World\" }"
    }
}
