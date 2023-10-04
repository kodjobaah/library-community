

import javax.persistence.*

@Entity
data class Person(
        @Id
        val email: String,

        var firstName: String,

        var lastName: String,

        var type: String

) {
    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "order")
    private val _borrowedBooks = mutableListOf<Book>()

    @Transient
    val books = _borrowedBooks.toList()

    fun borrowBook(book: Book) = this._borrowedBooks.plusAssign(newItem)
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
