package com.patchwork.library

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

class ErrorMessageModel(
    var status: Int? = null,
    var message: String? = null
)

class BookNotAvailableException(message: String) : RuntimeException(message) {
}

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun BookNotAvailableException(ex: BookNotAvailableException): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
            HttpStatus.UNAUTHORIZED.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }
}

