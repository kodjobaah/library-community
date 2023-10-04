

data Book()

@Table("MESSAGES")
data class Book(@Id var isbn: String?, val text: String)