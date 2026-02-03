package com.example.crud.controller

import com.example.crud.service.FakerApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/faker")
class FakerController(private val fakerApiService: FakerApiService) {
    @GetMapping("/persons")
    fun fetchFakePersons(@RequestParam quantity: Int) :
            String{
        return fakerApiService.getFakePersons(quantity)
    }
}