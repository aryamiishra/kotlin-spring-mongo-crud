package com.example.crud.service.query

import com.example.crud.exception.UserNotFoundException
import com.example.crud.model.User
import com.example.crud.repository.UserRepository
import com.example.crud.service.command.CreateUserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.springframework.aot.hint.TypeReference.listOf
import java.util.Optional

@ExtendWith(MockitoExtension::class)
class GetUserServiceTest {
    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var getUserService: GetUserService

    @Test
    fun shouldReturnAllUsers() {
        val user = listOf(
            User("1", "John", "john@test.com", 21),
            User("2", "Jane", "jane@test.com", 22)
        )
        whenever(userRepository.findAll()).thenReturn(user)

        val result = getUserService.getAll()
        assertEquals("John",result[0].name)
    }

    @Test
    fun shouldReturnUserById(){
        val user = User("1", "John", "john@test.com", 21 )

        whenever(userRepository.findById("1")).thenReturn(Optional.of(user))
        val result = getUserService.getById("1")
        assertEquals("John",result.name)
    }

    @Test
    fun shouldThrowExceptionWhenUserIsNotFoundById(){
        whenever(userRepository.findById("1")).thenReturn(Optional.empty())

        assertThrows(UserNotFoundException::class.java) { getUserService.getById("1") }

    }

    @Test
    fun shouldReturnUserByName(){
        val user = User("1", "John", "john@test.com", 21)
        whenever(userRepository.findByName("John")).thenReturn(user)
        val result = getUserService.getByName("John")
        assertEquals("John",result.name)
    }

    @Test
    fun shouldThrowExceptionWhenUserIsNotFoundByName(){
        whenever(userRepository.findByName("John")).thenReturn(null)

        assertThrows(UserNotFoundException::class.java) { getUserService.getByName("John") }
    }

    @Test
    fun shouldReturnUserByAge(){
        val users = listOf(
            User("1", "John", "john@test.com", 20),
            User("2", "Jane", "jane@test.com", 20)
        )
        whenever(userRepository.findByAge(20)).thenReturn(users)
        val result = getUserService.getByAge(20)

        assertEquals(2,result.size)
    }

    @Test
    fun shouldThrowExceptionWhenUserIsNotFoundByAge(){
        whenever(userRepository.findByAge(20)).thenReturn(emptyList<User>())
        assertThrows(UserNotFoundException::class.java) { getUserService.getByAge(20) }
    }

    @Test
    fun shouldReturnUserByNameAndAge(){
        val users = listOf(
            User("1", "John", "john@test.com", 21)
        )
        whenever(userRepository.findByAgeAndName(21, "John")).thenReturn(users)
        val result = getUserService.getByNameAndAge("John", 21)
        assertEquals(1,result.size)
        assertEquals("John",result[0].name)
    }

    @Test
    fun shouldThrowExceptionWhenUserIsNotFoundByNameAndAge(){
        whenever(userRepository.findByAgeAndName(21, "John")).thenReturn(emptyList<User>())
        assertThrows(UserNotFoundException::class.java) { getUserService.getByNameAndAge("John", 21) }
    }
}