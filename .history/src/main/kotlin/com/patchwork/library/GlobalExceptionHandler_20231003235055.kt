package com.patchwork.library

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
            HttpStatusUNAUTHORIZED.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }
}

