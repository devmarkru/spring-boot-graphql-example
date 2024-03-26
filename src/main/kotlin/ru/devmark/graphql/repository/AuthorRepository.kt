package ru.devmark.graphql.repository

import org.springframework.stereotype.Repository
import ru.devmark.graphql.model.Author
import java.time.LocalDate

@Repository
class AuthorRepository {

    fun getById(authorId: Int): Author {
        println("Find author by id: $authorId")
        return AUTHORS[authorId]
            ?: throw RuntimeException("Not found")
    }

    fun getAllByIds(ids: Set<Int>): Map<Int, Author> =
        AUTHORS
            .filterKeys { it in ids }
            .also { println("Get by ids: $ids") }

    private companion object {
        val AUTHORS = listOf(
            Author(1, "Лев", "Толстой", LocalDate.of(1828, 9, 9)),
            Author(2, "Александр", "Пушкин", LocalDate.of(1799, 6, 6)),
        ).associateBy { it.id }
    }
}
