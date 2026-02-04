package com.example.crud.service.command

import com.example.crud.dto.UpdateUserRequest
import com.example.crud.exception.UserNotFoundException
import com.example.crud.model.User
import com.example.crud.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.util.Optional


@ExtendWith(MockitoExtension::class)
class UpdateUserServiceTest {
    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var updateUserService: UpdateUserService

    @Test
    fun shouldUpdateSuccessfully(){
        val existingUser = User("1", "John", "john@test.com", 21)

        val request = UpdateUserRequest("Jane", "jane@test.com", 25)

        val savedUser = existingUser.copy(
            name = "Jane",
            email = "jane@test.com",
            age = 25
        )
        whenever(userRepository.findById(any())).thenReturn(Optional.of(existingUser))
        whenever(userRepository.save(any())).thenReturn(savedUser)

        val result = updateUserService.update("1", request)

        assertEquals("Jane", result.name)
        assertEquals(25, result.age)
        assertEquals("jane@test.com", result.email)

        verify(userRepository).save(any())

    }

    @Test
    fun shouldThrowExceptionWhenUserNotFoundById() {
        val request = UpdateUserRequest("Jane", "jane@test.com", 21)

        whenever(userRepository.findById(any())).thenReturn(Optional.empty())
        assertThrows(UserNotFoundException::class.java ) { updateUserService.update("1", request) }

        verify(userRepository, never()).save(any())

    }
}