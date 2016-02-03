package id.durkin.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PERSON_BOOK")
@AssociationOverrides({
		@AssociationOverride(name = "pk.person", 
			joinColumns = @JoinColumn(name = "PERSON_ID")),
		@AssociationOverride(name = "pk.book", 
			joinColumns = @JoinColumn(name = "BOOK_ID")) })
public class PersonBook implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private PersonBookId pk = new PersonBookId();

	public PersonBook() {
	}

	@EmbeddedId
	public PersonBookId getPk() {
		return pk;
	}

	public void setPk(PersonBookId pk) {
		this.pk = pk;
	}

	@Transient
	public Person getPerson() {
		return getPk().getPerson();
	}

	public void setPerson(Person person) {
		getPk().setPerson(person);
	}

	@Transient
	public Book getBook() {
		return getPk().getBook();
	}

	public void setBook(Book book) {
		getPk().setBook(book);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PersonBook that = (PersonBook) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}
