

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
    private val _books = mutableListOf<LineItem>()

    @Transient
    val lineItems = _lineItems.toList()

    fun addLineItem(newItem: LineItem) = this._lineItems.plusAssign(newItem)
}

@Entity
data class Book(
        @Id
        val isbn: String,

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "book_id")
        val person: Per? = null
)

data Book()

@Table("MESSAGES")
data class Book(@Id var isbn: String?, val author: String, val title: String)