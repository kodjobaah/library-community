

import javax.persistence.*

@Entity
data class User(
        @Id
        val isbn: String,

        var author: String,

        var lastName: String

) {
    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "order")
    private val _lineItems = mutableListOf<LineItem>()

    @Transient
    val lineItems = _lineItems.toList()

    fun addLineItem(newItem: LineItem) = this._lineItems.plusAssign(newItem)
}

@Entity
data class LineItem(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = -1,

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "order_id")
        val order: OrderEntity? = null
)

data Book()

@Table("MESSAGES")
data class Book(@Id var isbn: String?, val author: String, val title: String)