package com.patchwork.library

class BookNotAvailableException(message: String) : RuntimeException(message) {
}

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
fun handleArticleNotFoundException(ex: ArticleNotFoundException): ResponseEntity<ErrorMessageModel> {
    val errorMessage = ErrorMessageModel(
        HttpStatus.NOT_FOUND.value(),
        ex.message
    )
    return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
}

    @ExceptionHandler
    fun handleIllegalStateException(ex: IllegalStateException): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }
}

