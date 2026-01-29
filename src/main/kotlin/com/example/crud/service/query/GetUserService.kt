package com.example.crud.service.query

import com.example.crud.dto.UserResponse
import com.example.crud.exception.UserNotFoundException
import com.example.crud.repository.UserRepository
import io.lettuce.core.KillArgs.Builder.user
import org.springframework.stereotype.Service

@Service
class GetUserService(private val userRepository: UserRepository) {
    fun getAll(): List<UserResponse> =
        userRepository.findAll().map {
            UserResponse(it.id!!, it.name, it.email, it.age)
    }
    fun getById(id: String): UserResponse {
        val user = userRepository.findById(id)
            .orElseThrow { UserNotFoundException("User with id $id not found") }

        return UserResponse(user.id!!, user.name, user.email, user.age)
    }
    open fun getByName(name: String): UserResponse {
        val user = userRepository.findByName(name)
            ?: throw UserNotFoundException("User with name $name not found")

        return UserResponse(
            id = user.id!!,
            name = user.name,
            email = user.email,
            age = user.age
        )
    }
    fun getByAge(age: Int): List<UserResponse> {
        val users = userRepository.findByAge(age)

        if (users.isEmpty()) {
            throw UserNotFoundException("No users found with age $age")
        }

        return users.map { user ->
            UserResponse(
                id = user.id!!,
                name = user.name,
                email = user.email,
                age = user.age
            )
        }
    }

}