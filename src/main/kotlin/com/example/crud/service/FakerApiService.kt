package com.example.crud.service

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class FakerApiService(
    private val webClient: WebClient
) {

    fun getFakePersons(quantity: Int): String {
        return webClient.get()
            .uri("/api/v1/persons?_quantity=$quantity")
            .retrieve()
            .bodyToMono(String::class.java)
            .block()
            ?: throw RuntimeException("No response from Faker API")
    }
}