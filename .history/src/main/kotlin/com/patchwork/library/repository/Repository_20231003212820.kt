
package com.patchwork.library.repository

import org.springframework.data.repository.CrudRepository

import com.patchwork.library.model.Book
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, Long> {

        fun findByAuthor(author: String): Iterable<Book>

        fun findByTitle(title: String): Iterable<Book>

        fun findByIsbn(isbn: String): Iterable<Book>
}

@Repository
interface BookRepository : CrudRepository<Book, Long> {

        fun findByAuthor(author: String): Iterable<Book>

        fun findByTitle(title: String): Iterable<Book>

        fun findByIsbn(isbn: String): Iterable<Book>
}