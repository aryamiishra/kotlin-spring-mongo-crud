/*package com.example.crud.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ThreadCommunicationService {
    private val log = LoggerFactory.getLogger(ThreadCommunicationService::class.java)
    private val lock = Object()
    private var dataReady = false

    fun waitingThread(){
        val thread = Thread{
            synchronized(lock){
                log.info("Waiting thread: checking condition")

                while (!dataReady) {
                    log.info("Waiting thread: data not ready")
                    lock.wait()
                }
                log.info("Waiting thread: data received, resuming work")
            }
        }
        thread.start()
    }

    fun notifyingThread(){
        val thread = Thread {
            Thread.sleep(3000)

            synchronized(lock){
                log.info("Notifying thread: preparing data")
                dataReady = true
                lock.notify()
                log.info("Notifying thread: sent notification")
            }
        }
        thread.start()
    }
}*/