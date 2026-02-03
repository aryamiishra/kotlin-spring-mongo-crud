package com.example.crud.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.locks.ReentrantLock

@Service
class ReentrantLockService {
    private val log = LoggerFactory.getLogger(ReentrantLockService::class.java)
    private val lock = ReentrantLock()
    private var counter = 0

    fun incrementCounter(threadName:String){
        lock.lock()
        try{
            val current = counter
            Thread.sleep(500)
            counter = current+1
            log.info("counter = $counter")
        } finally {
            lock.unlock()
        }
    }

    fun startThreads(){
        val thread1 = Thread {
            repeat(5){
                incrementCounter("Thread 1")
            }
        }
        val thread2 = Thread {
            repeat(5){
                incrementCounter("Thread 2")
            }
        }
        thread1.start()
        thread2.start()
    }
}