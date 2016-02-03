package id.durkin.repositories;

import org.springframework.data.repository.CrudRepository;

import id.durkin.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
