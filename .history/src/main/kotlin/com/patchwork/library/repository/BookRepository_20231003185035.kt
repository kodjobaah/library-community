
package com.patchwork.library.repository

import org.springframework.data.repository.CrudRepository

import com.pathwork..model.Book
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, Long> {

        fun findByLastName(lastName: String): Iterable<Customer>
}