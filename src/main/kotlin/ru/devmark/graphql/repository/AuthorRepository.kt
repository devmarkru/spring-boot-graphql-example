package ru.devmark.graphql.repository

import org.springframework.stereotype.Repository
import ru.devmark.graphql.model.Author

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
            Author(1, "Лев", "Толстой"),
            Author(2, "Александр", "Пушкин"),
        ).associateBy { it.id }
    }
}
