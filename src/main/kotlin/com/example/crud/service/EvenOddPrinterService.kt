package com.example.crud.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EvenOddPrinterService {
    private val log = LoggerFactory.getLogger(javaClass)
    private val lock = Object()
    private var number = 0
    private val n = 27

    fun printOdd(){
        val oddThread = Thread{
            synchronized(lock){
                while (number <= n){
                  while (number % 2 == 0) {
                      lock.wait()
                  }
                  if (number <= n){
                      log.info("Odd: $number")
                      number++
                      lock.notifyAll()
                  }
                }
            }
        }
        oddThread.start()
    }

    fun printEven(){
        val oddThread = Thread{
            synchronized(lock){
                while (number <= n){
                    while (number % 2 != 0){
                        lock.wait()
                    }
                    if (number <= n){
                        log.info("Even: $number")
                        number++
                        lock.notifyAll()
                    }
                }
            }
        }
        oddThread.start()
    }

    fun startPrinting(){
        printOdd()
        printEven()
    }
}