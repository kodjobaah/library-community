

import javax.persistence.*

@Entity
data class Person(
        @Id
        val email: String,

        @Column(name = "first_name")
        lateinit var firstName: String
    
        @Column(name = "last_name")
        lateinit var lastName: String
        lateinit var firstName: String,

        lateinit var lastName: String,

        var type: String

) {
    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "book")
    private val _borrowedBooks = mutableListOf<Book>()

    @Transient
    val books = _borrowedBooks.toList()

    fun borrowBook(book: Book) = this._borrowedBooks.plusAssign(book)
}

@Entity
data class Book(
        @Id
        val isbn: String,

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "book_id")
        val borrow: Person? = null

        val type: String,
)
