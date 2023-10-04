
package com.patchwork.library.model

import jakarta.persistence.*;

enum class Role {
        OWNER, USER
}

enum class BookType {
        REFERENCE, NORMAL
}

data class BorrowBook(val email: String, val isbn: String )

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
    
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Person

        return email != null && email == other.email
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(email = $id , title = $title , content = $content )"
    }
}

@Entity
data class Book(
        @Id
        val isbn: String,
        
        @Column
        val author: String,

        @Column
        val title: String,

        @Column(name="book_type")
        @Enumerated(EnumType.STRING)
        val bookType: BookType,
        
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "borrow_id")
        var borrower: Person? = null
)
