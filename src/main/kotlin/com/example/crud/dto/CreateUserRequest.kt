package com.example.crud.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class CreateUserRequest(
    @field:NotBlank
    val name: String,


    @field:Email
    val email: String,

    @field:Positive
    val age: Int
)
