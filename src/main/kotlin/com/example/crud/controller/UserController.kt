package com.example.crud.controller

import com.example.crud.dto.CreateUserRequest
import com.example.crud.dto.UpdateUserRequest
import com.example.crud.service.command.CreateUserService
import com.example.crud.service.command.DeleteUserService
import com.example.crud.service.command.UpdateUserService
import com.example.crud.service.query.GetUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val createUserService: CreateUserService,
    private val updateUserService: UpdateUserService,
    private val deleteUserService: DeleteUserService,
    private val getUserService: GetUserService
) {
    @PostMapping
    fun create(@RequestBody request: CreateUserRequest) =
        ResponseEntity.ok(createUserService.create(request))


    @GetMapping
    fun getAll() =
        ResponseEntity.ok(getUserService.getAll())


    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) =
        ResponseEntity.ok(getUserService.getById(id))

    @GetMapping("/search")
    fun getByName(@RequestParam name: String) =
        ResponseEntity.ok(getUserService.getByName(name))

    @GetMapping("/searchAge")
    fun getByAge(@RequestParam age: Int) =
        ResponseEntity.ok(getUserService.getByAge(age))


    @GetMapping("/by-name-age")
    fun getByAgeAndName(@RequestParam age: Int, @RequestParam name: String) =
        ResponseEntity.ok(getUserService.getByNameAndAge(name, age))


    @PutMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @RequestBody request: UpdateUserRequest
    ) =
        ResponseEntity.ok(updateUserService.update(id, request))


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Void> {
        deleteUserService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/search")
    fun deleteByName(@RequestParam name: String): ResponseEntity<Void> {
        deleteUserService.removeByName(name)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/email")
    fun deleteByEmail(@RequestParam email: String): ResponseEntity<Void> {
        deleteUserService.removeByEmail(email)
        return ResponseEntity.noContent().build()
    }
}