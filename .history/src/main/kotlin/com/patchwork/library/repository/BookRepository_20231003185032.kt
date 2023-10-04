
package com.patchwork.library.repository

import org.springframework.data.repository.CrudRepository

import com.pathwork..model.Book
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Customer, Long> {

        fun findByLastName(lastName: String): Iterable<Customer>
}