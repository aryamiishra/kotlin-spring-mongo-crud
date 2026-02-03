package com.example.crud.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ThreadLifeCycle {

    companion object {
        private val lock = Object()
    }

    private val log = LoggerFactory.getLogger(ThreadLifeCycle::class.java)

    fun runDemo() {
        log.info("===== THREAD DEMO STARTED =====")

        val thread1 = Thread {
            log.info("Thread 1 started")
            Thread.sleep(3000)
            log.info("Thread 1 finished")
        }

        val thread2 = Thread {
            log.info("Thread 2 trying to acquire lock")
            synchronized(lock) {
                log.info("Thread 2 acquired lock")
                Thread.sleep(2000)
            }
            log.info("Thread 2 released lock")
        }

        val thread3 = Thread {
            log.info("Thread 3 trying to acquire lock")
            synchronized(lock) {
                log.info("Thread 3 acquired lock")
            }
        }

        val thread4 = Thread {
            log.info("Thread 4 waiting for Thread 1 to finish")
            thread1.join()
            log.info("Thread 4 resumed after Thread 1 finished")
            Thread.sleep(2000)
            log.info("Thread 4 finished")

        }

        thread1.start()
        thread2.start()
        thread3.start()
        thread4.start()
    }
}
