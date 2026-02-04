/*package com.example.crud.service

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ReentrantLockScheduler(private val service: ReentrantLockService) {
    @Scheduled(fixedDelay = 40000)
    fun runReentrantLock(){
        service.startThreads()
    }
}*/