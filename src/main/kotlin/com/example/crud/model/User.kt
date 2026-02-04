package com.example.crud.model

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.index.Indexed

@Document(collection = "users")
@CompoundIndexes(
    CompoundIndex(
        name = "age_name_idx",
        def = "{'age': 1, 'name': 1}"
    )
)
data class User(
    @Id
    val id: String? = null,

    @field:NotBlank(message = "Name cannot be empty")
    val name: String,

    @Indexed( unique = true )
    @field:Email(message = "Email cannot be empty")
    val email: String,

    @field:Positive(message = "Age must be positive")
    val age: Int
)
