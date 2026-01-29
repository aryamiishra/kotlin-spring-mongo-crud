package com.example.crud.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Positive

data class UpdateUserRequest(
    val name: String?,
    @field:Email
    val email: String?,
    @field:Positive
    val age: Int?
)
