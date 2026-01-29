package com.example.crud.model

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

@Document(collection = "users")
data class User(
    @Id
    val id: String? = null,

    @field:NotBlank(message = "Name cannot be empty")
    val name: String,

    @field:Email(message = "Email cannot be empty")
    val email: String,

    @field:Positive(message = "Age must be positive")
    val age: Int
)
