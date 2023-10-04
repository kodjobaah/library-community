package com.patchwork.library.service

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;

import java.util.*

import com.patchwork.library.model.Book
import com.patchwork.library.repository.BookRepository

enum class Availability(availability: String) {
    AVAILABLE("Available"), UNAVAILABLE("Unavailable");
}

val transformBook: (Book) -> BookAvailability = {
    BookAvailability(
        it.isbn,
        it.author,
        it.title,
        if (it.borrower != null) Availability.AVAILABLE  else Availability.UNAVAILABLE
     )
    }

data class BookAvailability (
    val isbn: String,
    val author: String,
    val title: String,
    val availability: Availability
)

@Service
class BookService(val db: BookRepository) {
    
    fun findByAuthor(author: String): List<BooAk> {
       return db.findByAuthor(author).toList().map(transformBook)

    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}