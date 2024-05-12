package ru.devmark.graphql.repository

import org.springframework.stereotype.Repository
import ru.devmark.graphql.model.Book
import java.math.BigDecimal

@Repository
class BookRepository {

    fun getAll(limit: Int): List<Book> =
        BOOKS
            .values
            .take(limit)
            .also { println("Get all books, limit: $limit.") }

    fun findById(id: Int): Book? =
        BOOKS[id]

    private companion object {
        val BOOKS = listOf(
            Book(11, "Война и мир", 1, BigDecimal("1000.25")),
            Book(12, "Евгений Онегин", 2, BigDecimal("301.08")),
            Book(13, "Воскресение", 1, BigDecimal("517.30")),
            Book(14, "Анна Каренина", 1, BigDecimal("755.02")),
        ).associateBy { it.id }
    }
}
