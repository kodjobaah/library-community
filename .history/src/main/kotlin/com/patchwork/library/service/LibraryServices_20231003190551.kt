package com.patchwork.library.service

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;

import java.util.*

import com.patchwork.library.
import com.patchwork.library.repository.BookRepository

@Service
class BookService(val db: BookRepository) {
    fun findByAuthor(author: String): List<Book> = db.findByAuthor(author).toList()

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}