package com.example.crud.service.command

import com.example.crud.dto.CreateUserRequest
import com.example.crud.dto.UserResponse
import com.example.crud.exception.DuplicateUserException
import com.example.crud.model.User
import com.example.crud.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class CreateUserService(
    private val userRepository: UserRepository
) {


    fun create(request: CreateUserRequest): User {
        if (userRepository.findByEmail(request.email) != null) {
            throw DuplicateUserException("User with email ${request.email} already exists")
        }


        return userRepository.save(
            User(
                name = request.name,
                email = request.email,
                age = request.age
            )
        )
    }
}