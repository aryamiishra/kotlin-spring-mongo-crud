package com.example.crud


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
@EnableScheduling
class KotlinSpringMongoCrudApplication


fun main(args: Array<String>) {
    runApplication<KotlinSpringMongoCrudApplication>(*args)
}