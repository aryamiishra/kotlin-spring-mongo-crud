package com.example.crud.service.command

import com.example.crud.dto.CreateUserRequest
import com.example.crud.exception.DuplicateUserException
import com.example.crud.model.User
import com.example.crud.repository.UserRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.kotlin.verify
import org.junit.jupiter.api.Assertions.assertThrows
import org.mockito.kotlin.never


@ExtendWith(MockitoExtension::class)
class CreateUserServiceTest {
    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var createUserService: CreateUserService

    @Test
    fun shouldCreateUserSuccessfully() {
        val request = CreateUserRequest(
            name = "John",
            email= "johndoe@gmail.com",
            age = 19
        )
        val savedUser = User(
            id = "1",
            name = "John",
            email = "johndoe@gmail.com",
            age = 19
        )
        whenever(userRepository.save(any())).thenReturn(savedUser)

        val result = createUserService.create(request)

        assertEquals("John", result.name)
        verify(userRepository).save(any())
    }

    @Test
    fun shouldThrowExceptionWhenUserAlreadyExists() {
        val request = CreateUserRequest(
            name = "John",
            email = "johndoe@gmail.com",
            age = 19
        )

        val existingUser = User(
            id = "1",
            name = "John",
            email = "johndoe@gmail.com",
            age = 19
        )

        whenever(userRepository.findByEmail("johndoe@gmail.com")).thenReturn(existingUser)

        assertThrows(DuplicateUserException::class.java){
            createUserService.create(request)
        }

        verify(userRepository, never()).save(any())
    }

}