package com.patchwork.library.service

import java.util.*

import com.patchwork.library.repository.BookRepository

@Service
class BookService(val db: BookRepository) {
    fun findByAuthor(author: String): List<Book> = db.findByAuthor(author).toList()

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}