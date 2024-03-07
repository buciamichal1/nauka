import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController {
    private val books = mutableListOf<Book>()
    private var nextId = 1L

    @PostMapping
    fun addBook(@RequestBody book: Book): Book {
        book.id = nextId++
        books.add(book)
        return book
    }

    @GetMapping
    fun getAllBooks(): List<Book> {
        return books
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long): Book? {
        return books.find { it.id == id }
    }

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody updatedBook: Book): Book? {
        val index = books.indexOfFirst { it.id == id }
        if (index != -1) {
            updatedBook.id = id
            books[index] = updatedBook
            return updatedBook
        }
        return null
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long) {
        books.removeIf { it.id == id }
    }
}
