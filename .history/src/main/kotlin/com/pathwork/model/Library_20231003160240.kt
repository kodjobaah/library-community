

import javax.persistence.*;


@Entity
data class Person(
        @Id
        val email: String,

        @Column(name = "role")
        lateinit var role: String

) {
    @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = false, fetch = FetchType.LAZY, mappedBy = "books")
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

        @Column
        val bookType: String,
        
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "borrow_id")
        val borrower: Person? = null
)
