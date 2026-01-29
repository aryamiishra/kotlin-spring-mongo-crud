package com.example.crud.service.command

import com.example.crud.dto.UpdateUserRequest
import com.example.crud.dto.UserResponse
import com.example.crud.repository.UserRepository
import org.springframework.stereotype.Service
import com.example.crud.exception.UserNotFoundException

@Service
class UpdateUserService(
    private val userRepository: UserRepository
) {

    fun update(id: String, request: UpdateUserRequest) =
        userRepository.findById(id)
            .map { user ->
                user.copy(
                    name = request.name ?: user.name,
                    email = request.email ?: user.email,
                    age = request.age ?: user.age
                )
            }
            .map(userRepository::save)
            .orElseThrow {
                UserNotFoundException("User not found with id $id")
            }
}