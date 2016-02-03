package id.durkin.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PersonBookId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Person person;
    private Book book;

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonBookId that = (PersonBookId) o;

        if (person != null ? !person.equals(that.person) : that.person != null) return false;
        if (book != null ? !book.equals(that.book) : that.book != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (person != null ? person.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
    }
    
}