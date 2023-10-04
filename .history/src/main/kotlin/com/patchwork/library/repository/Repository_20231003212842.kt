
package com.patchwork.library.repository

import org.springframework.data.repository.CrudRepository

import com.patchwork.library.model.Book
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, String> {

        fun findByAuthor(author: String): Iterable<Book>

        fun findByTitle(title: String): Iterable<Book>

        fun findByIsbn(isbn: String): Iterable<Book>
}

@Repository
interface PersonRepository : CrudRepository<Person, String> {

        fun findByAuthor(author: String): Iterable<Book>

        fun findByTitle(title: String): Iterable<Book>

        fun findByIsbn(isbn: String): Iterable<Book>
}