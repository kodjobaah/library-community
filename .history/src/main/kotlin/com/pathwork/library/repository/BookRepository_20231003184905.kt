
package com.pathwork.library.repor

import org.springframework.data.repository.CrudRepository

import com.kotlination.jpapostgresql.model.Customer
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Long> {

        fun findByLastName(lastName: String): Iterable<Customer>
}