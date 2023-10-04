package com.patchwork.library.service

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;

import java.util.*

import com.patchwork.library.model.Book
import com.patchwork.library.model.BorrowBook
import com.patchwork.library.model.Person
import com.patchwork.library.model.PersonBook
import com.patchwork.library.repository.BookRepository
import com.patchwork.library.repository.PersonRepository

enum class Availability(availability: String) {
    AVAILABLE("Available"), UNAVAILABLE("Unavailable");
}

val transformBook: (Book) -> BookAvailability = {
    BookAvailability(
        it.isbn,
        it.author,
        it.title,
        if (it.borrower == null) Availability.AVAILABLE  else Availability.UNAVAILABLE
     )
    }

val transformPerson: (Person) -> PersonBook = {
        PersonBook(
            it.email,
            it.books()
         )
        }    

data class BookAvailability (
    val isbn: String,
    val author: String,
    val title: String,
    val availability: Availability
)

@Service
class BookService(val bookDb: BookRepository, val personDb: PersonRepository) {
    
    fun findByAuthor(author: String): List<BookAvailability> {
       return bookDb.findByAuthor(author).toList().map(transformBook)

    }

    fun findByTitle(title: String): List<BookAvailability> {
        return bookDb.findByTitle(title).toList().map(transformBook)
 
     }

     fun findByIsbn(isbn: String): List<BookAvailability> {
        return bookDb.findByIsbn(isbn).toList().map(transformBook)
     }

     fun borrowBook(borrowBook: BorrowBook): Person {
        val person = personDb.findById(borrowBook.email).get()
        val bookHolder  = bookDb.findById(borrowBook.isbn)

        if (!bookHolder.isPresent()) {
            throw BookNotAvailableException("Book does not exist $borrowBook.isbn")
        }

        val book = bookHolder.get
        
        if book.borrow != null {
            throw BookNotAvailableException("Some one has already borrowed this book $borrowBook.isbn")  
        }

        book.borrower = person
        person.borrowBook(book)
        val p = personDb.save(person)
        bookDb.save(book)
        return person.map(transformPerson).get()
     }

     fun getPerson(email: String): PersonBook {
        val person = personDb.findById(email)
        return person.map(transformPerson).get()
     }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}