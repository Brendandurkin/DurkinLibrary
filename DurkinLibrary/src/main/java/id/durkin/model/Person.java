package id.durkin.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {

	private Integer id;
	private String name;
	private String email;
	private String phone;

	public Person() {}
	
	public Person(String name, String phone, String email) {
		this.name=name;
		this.phone=phone;
		this.email=email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private Set<PersonBook> personBooks = new HashSet<PersonBook>(0);

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
	@SequenceGenerator(name = "person_id_seq", sequenceName = "PERSON_ID_SEQ", allocationSize = 100)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.person", cascade = CascadeType.ALL)
	public Set<PersonBook> getPersonBooks() {
		return this.personBooks;
	}

	public void setPersonBooks(Set<PersonBook> personBooks) {
		this.personBooks = personBooks;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

}
