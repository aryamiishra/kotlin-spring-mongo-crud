package com.example.crud.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFound(ex: UserNotFoundException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(DuplicateUserException::class)
    fun handleDuplicateUser(ex: DuplicateUserException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.CONFLICT)
    }
    @ExceptionHandler(Exception::class)
    fun handleGeneric(ex: Exception): ResponseEntity<String> {
        return ResponseEntity("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR)
    }
}