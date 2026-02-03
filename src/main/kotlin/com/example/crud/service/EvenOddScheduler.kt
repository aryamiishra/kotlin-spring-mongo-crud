package com.example.crud.service

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class EvenOddScheduler(private val service: EvenOddPrinterService) {
    @Scheduled(fixedDelay = 15000)
    fun runEvenOdd(){
        service.startPrinting()
    }
}