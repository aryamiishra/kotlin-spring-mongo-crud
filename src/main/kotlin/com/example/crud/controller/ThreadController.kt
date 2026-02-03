package com.example.crud.controller

import com.example.crud.service.ThreadLifeCycle
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/threads")
class ThreadController(
    private val threadLifeCycle: ThreadLifeCycle
) {

    @GetMapping("/run")
    fun runThreads(): String {
        threadLifeCycle.runDemo()
        return "Threads started. Check console logs."
    }
}
