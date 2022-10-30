package ru.devmark.graphql.repository

import org.springframework.stereotype.Repository
import ru.devmark.graphql.model.Book

@Repository
class BookRepository {

    fun getAll(limit: Int): List<Book> =
        BOOKS
            .take(limit)
            .also { println("Get all books, limit: $limit.") }

    private companion object {
        val BOOKS = listOf(
            Book(11, "Война и мир", 1),
            Book(12, "Евгений Онегин", 2),
            Book(13, "Воскресение", 1),
            Book(14, "Анна Каренина", 1),
        )
    }
}
