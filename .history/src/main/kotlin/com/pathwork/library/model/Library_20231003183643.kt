
package com.pathwork.library.model

import jakarta.persistence.*;

enum class Role {
        OWNER, USER
}

enum class BookType {
        REFERENCE, NORMAL
}

@Entity
data class Person(
        @Id
        val email: String,

        @Column(name = "role")
        @Enumerated(EnumType.STRING)
        var role: Role

) {
    @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = false, fetch = FetchType.LAZY, mappedBy = "borrower")
    private val _borrowedBooks = mutableListOf<Book>()

    @Transient
    val books = _borrowedBooks.toList()

    fun borrowBook(book: Book) = this._borrowedBooks.plusAssign(book)
}

@Entity
data class Book(
        @Id
        val isbn: String,
        
        @Column
        val author: String,

        @Column
        val title: String,

        @Column("book_type")
        @Enumerated(EnumType.STRING)
        val bookType: BookType,
        
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "borrow_id")
        val borrower: Person? = null
)
