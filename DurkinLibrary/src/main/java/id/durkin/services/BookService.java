package id.durkin.services;

import id.durkin.model.Book;

public interface BookService {

	Iterable<Book> listAllBooks();

	Book getBookById(Integer id);

	Book saveBook(Book book);

    void deleteBook(Integer id);
}
