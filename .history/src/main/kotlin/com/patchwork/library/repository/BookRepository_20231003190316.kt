
package com.patchwork.library.repository

import org.springframework.data.repository.CrudRepository

import com.patchwork.library.model.Book
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, Long> {

        fun findByAuthor(author: String): Iterable<Book>
}