/*package com.example.crud.service

import com.example.crud.service.ThreadCommunicationService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class CommunicationScheduler(private val service: ThreadCommunicationService) {
    @Scheduled(fixedDelay = 10000)
    fun runDemo(){
        service.waitingThread()
        service.notifyingThread()
    }

}*/