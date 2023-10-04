package com.patchwork.library

import org.springframework.http.HttpStatus
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

