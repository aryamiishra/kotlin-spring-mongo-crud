package com.example.crud.service.command

import com.example.crud.exception.UserNotFoundException
import com.example.crud.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class DeleteUserService(private val userRepository: UserRepository) {
    fun deleteUser(id: String ) {
        val user = userRepository.findById(id)
            .orElseThrow{ UserNotFoundException("User with id $id not found") }

        userRepository.delete(user)
    }

    fun removeByEmail(email: String) {
        val user = userRepository.findByEmail(email)
            ?: throw UserNotFoundException("User with name $email not found")
        userRepository.delete(user)
    }

    fun removeByName(name: String) {
        val user = userRepository.findByName(name)
        ?: throw UserNotFoundException("User with name $name not found")

        userRepository.delete(user)
    }

}