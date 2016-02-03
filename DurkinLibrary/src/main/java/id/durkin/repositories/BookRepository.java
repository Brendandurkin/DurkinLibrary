package id.durkin.repositories;

import org.springframework.data.repository.CrudRepository;

import id.durkin.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
