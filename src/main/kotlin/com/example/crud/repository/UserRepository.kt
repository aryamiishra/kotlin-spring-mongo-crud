package com.example.crud.repository

import com.example.crud.dto.UserResponse
import com.example.crud.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
    fun existsByEmail(email: String): Boolean
    fun findByAgeGreaterThan(age: Int): List<User>
    fun findByName(name: String): User?
    fun findByAge(age: Int): List<User>
    fun findByAgeLessThan(age: Int): List<User>
    fun findByAgeBetween(age: Int, lowerBound: Int, upperBound: Int): List<User>
    fun findByAgeAndName(age: Int, name: String): User?
    fun findByEmail(email: String): User?


}