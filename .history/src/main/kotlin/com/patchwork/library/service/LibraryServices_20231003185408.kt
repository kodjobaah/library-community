package com.patchwork.library.Service

import java.util.*

import com.patchwork.library.repository.BookRepository

@Service
class BookService(val db: BookRepository) {
    fun findByAuthor(author: String): List<Message> = db.findByAuthor(author).toList()

    fun findMessageById(id: String): List<Message> = db.findById(id).toList()

    fun save(message: Message) {
        db.save(message)
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}