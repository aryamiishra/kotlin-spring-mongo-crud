package com.example.crud.service

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.LocalTime


/*@Service
class PractiseScheduler {
    private val log = LoggerFactory.getLogger(PractiseScheduler::class.java)*/

    /*@Scheduled(cron =
    fun cronEveryFiveSeconds(){
        log.info("CRON Every-FiveSeconds running at ${LocalTime.now()}")
    }
    @Scheduled(fixedRate = 5000)
    fun fixedRate(){
        log.info("FIXED RATE Every-FiveSeconds running at ${LocalTime.now()}")
    }

    @Scheduled(fixedDelay = 5000)
    fun fixedDelay(){
        log.info("FIXED DELAY Every-FiveSeconds running at ${LocalDateTime.now()}")
        Thread.sleep(2000)
        log.info("FIXED DELAY end at ${LocalDateTime.now()}")
    }

    @Scheduled(cron = "0 0 9 * * *")
    fun morningJob(){
        log.info("Good Morning")
    }
}
*/
