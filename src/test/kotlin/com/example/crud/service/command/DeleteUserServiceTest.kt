package com.example.crud.service.command

import com.example.crud.exception.UserNotFoundException
import com.example.crud.model.User
import com.example.crud.repository.UserRepository
import com.example.crud.service.query.GetUserService
import io.lettuce.core.KillArgs.Builder.user
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
class DeleteUserServiceTest{

    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var deleteUserService: DeleteUserService

    @Test
    fun shouldDeleteUserByIdSuccessfully() {
        val user = User("1", "John", "johndoe@gmail.com", 19)
        whenever(userRepository.findById(any())).thenReturn(Optional.of(user))

        deleteUserService.deleteUser("1")
        verify(userRepository).delete(user)
    }

    @Test
    fun shouldThrowExceptionWhenUserIsNotFoundById() {
        whenever(userRepository.findById("1")).thenReturn(Optional.empty())

            assertThrows(UserNotFoundException::class.java) {
                deleteUserService.deleteUser("1")
        }
        verify(userRepository, never()).delete(any())
    }

    @Test
    fun shouldDeleteUserByEmailSuccessfully() {
        val user = User("1", "John", "johndoe@gmail.com", 19)
        whenever(userRepository.findByEmail("johndoe@gmail.com")).thenReturn(user)

        deleteUserService.removeByEmail("johndoe@gmail.com")
        verify(userRepository).delete(user)
    }

    @Test
    fun shouldThrowExceptionWhenUserIsNotFoundByEmail() {
        whenever(userRepository.findByEmail("johndoe@gmail.com")).thenReturn(null)

        assertThrows(UserNotFoundException::class.java) {
            deleteUserService.removeByEmail("johndoe@gmail.com")
        }
        verify(userRepository, never()).delete(any())

    }

    @Test
    fun shouldDeleteUserByNameSuccessfully() {
        val user = User("1", "John", "johndoe@gmail.com", 19)
        whenever(userRepository.findByName("John")).thenReturn(user)

        deleteUserService.removeByName("John")
        verify(userRepository).delete(user)
    }

    @Test
    fun shouldThrowExceptionWhenUserIsNotFoundByName() {
        whenever(userRepository.findByName("John")).thenReturn(null)

        assertThrows(UserNotFoundException::class.java) {
            deleteUserService.removeByName("John")
        }
        verify(userRepository, never()).delete(any())
    }
}