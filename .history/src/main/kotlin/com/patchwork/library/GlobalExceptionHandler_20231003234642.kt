package com.patchwork.library

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

@ExceptionHandler
fun handleArticleNotFoundException(ex: ArticleNotFoundException): ResponseEntity<ErrorMessageModel> {
    val errorMessage = ErrorMessageModel(
        HttpStatus.NOT_FOUND.value(),
        ex.message
    )
    return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
}