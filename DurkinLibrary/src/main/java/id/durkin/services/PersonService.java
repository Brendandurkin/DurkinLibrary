package id.durkin.services;

import id.durkin.model.Person;

public interface PersonService {

	Iterable<Person> listAllPeople();

	Person getPersonById(Integer id);

	Person savePerson(Person person);

    void deletePerson(Integer id);
}
