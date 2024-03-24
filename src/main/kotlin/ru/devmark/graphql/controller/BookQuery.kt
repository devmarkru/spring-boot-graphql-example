package ru.devmark.graphql.controller

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.BatchMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller
import ru.devmark.graphql.model.Author
import ru.devmark.graphql.model.Book
import ru.devmark.graphql.repository.AuthorRepository
import ru.devmark.graphql.repository.BookRepository

@Controller
class BookQuery(
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository,
) {

    @QueryMapping
    fun allBooks(@Argument limit: Int): List<Book> =
        bookRepository.getAll(limit)

//    @SchemaMapping(typeName = "Book", field = "author")
//    fun author(book: Book): Author =
//        authorRepository.getById(book.authorId)

    @BatchMapping
    fun author(books: List<Book>): Map<Book, Author> {
        val ids = books.map { it.authorId }.toSet()
        val authors = authorRepository.getAllByIds(ids)
        return books.associateWith { authors.getValue(it.authorId) }
    }
}