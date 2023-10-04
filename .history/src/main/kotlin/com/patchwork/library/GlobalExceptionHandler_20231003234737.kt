package com.patchwork.library

class BookNotAvailableException(message: String) : RuntimeException(message) {
}

@ControllerAdvice
class GlobalExceptionHandler {


    @ExceptionHandler
    fun handleIllegalStateException(ex: IllegalStateException): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }
}

