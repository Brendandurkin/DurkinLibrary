package id.durkin.boostrap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import id.durkin.model.Book;
import id.durkin.model.Person;
import id.durkin.model.PersonBook;
import id.durkin.repositories.BookRepository;
import id.durkin.repositories.PersonRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	
    private PersonRepository personRepository;
    private BookRepository bookRepository;

    private Logger log = Logger.getLogger(DataLoader.class);

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	

        long personCount = personRepository.count();

        log.info("Person Count is:" + personCount);

        // Create some example people....
        List<Person> personList = new ArrayList<>();
        if(personCount == 0){
        	
        	personList.add(new Person("Brendan Durkin","043 9955 714","brendan@durkin.id.au"));
        	personList.add(new Person("Chris Durkin","043 9955 715","chris@durkin.id.au"));
        	personList.add(new Person("Jack Sparrow","02 6266 6200","jsparrow@gmail.com"));
        	personList.add(new Person("Tony Collet","02 6266 6220","tcollet@gmail.com"));
        }

        // Create some example books....
        long bookCount = bookRepository.count();
        List<Book> bookList = new ArrayList<>();
        if(bookCount == 0){
        	bookList.add(new Book("Of Mice and Men","John-Steinbeck","13:9780141023571"));
        	bookList.add(new Book("The Lord of the Rings","J. R. R. Tolkien","978-0-517-22317-8"));
        	bookList.add(new Book("The Color of Magic","Terry Pratchett","978-1-85723-368-1"));
        }
        
        // Create a temporary Person lookup by name         
        Map<String, Person> personMap=personList.stream().collect(Collectors.toMap(p->p.getName(), p->p));
        
        // Create a temporary Book lookup by title         
        Map<String, Book> bookMap=bookList.stream().collect(Collectors.toMap(p->p.getTitle(), p->p));        
        
        // Now save all the books in one hit
        bookRepository.save(bookMap.values());
        
        // add some person/book relationships...
        linkPersonToBook(personMap, bookMap, "Brendan Durkin","Of Mice and Men", "The Lord of the Rings");
        linkPersonToBook(personMap, bookMap, "Chris Durkin","The Lord of the Rings");
        linkPersonToBook(personMap, bookMap, "Tony Collet","The Color of Magic");
        
        // Now save all the people in one hit
        personRepository.save(personMap.values());
        
    }

    /**
     * Creates a relationship between the subject person and the listed books.
     * <br>
     * Note: As this is just  a sample app there is no error handling
     *  
     * @param personMap - A map of all people by name
     * @param bookMap - A map of all books by title
     * @param personName - The name of the subject person
     * @param bookTitles - An array of book titles.
     */
    private void linkPersonToBook(Map<String, Person> personMap, Map<String, Book> bookMap, String personName, String... bookTitles ) {
    	Person person = personMap.get(personName);
    	Set<PersonBook> set = person.getPersonBooks();
    	for (String title:bookTitles) {
	        Book book = bookMap.get(title);        
	    	PersonBook personBook=new PersonBook();
	    	personBook.setPerson(person);
	    	personBook.setBook(book);
	    	set.add(personBook);
    	}
    }
}
