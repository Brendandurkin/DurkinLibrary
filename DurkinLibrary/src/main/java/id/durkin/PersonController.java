package id.durkin;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import id.durkin.model.Book;
import id.durkin.model.JsonResponse;
import id.durkin.model.Person;
import id.durkin.model.PersonBook;
import id.durkin.services.PersonService;

@Controller
public class PersonController {

	private PersonService personService;

	@Autowired
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value = "/")
	public String loadHomePage(Model model) {

		model.addAttribute("people", personService.listAllPeople());
		return "people";
	}

	@RequestMapping(value = "/people", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("people", personService.listAllPeople());
		return "people";
	}
	
	/**
	 * This is called from AJAX !!
	 * 
	 * @param id - The person id
	 * @return - A generic response pojo that holds the list of books linked to the person. 
	 */
	@RequestMapping(value = "/person/books/{id}", method = RequestMethod.GET)
	public  @ResponseBody JsonResponse getPersonBooks(@ PathVariable Integer id) {
		Person person = personService.getPersonById(id);
		JsonResponse resp=new JsonResponse();
		Set<PersonBook> personBooks = person.getPersonBooks();
		if (personBooks!=null && personBooks.size()>0) {
			List<Book> list = personBooks.stream().map(p->p.getBook()).collect(Collectors.toList());
			resp.setResult(list);
			resp.setStatus("SUCCESS");
		} else {
			resp.setStatus("NONE FOUND");
		}
		return resp;
	}


	@RequestMapping(value = "/person/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, Model model) {
		Person person = personService.getPersonById(id);
		model.addAttribute("person", person);
		return "personEdit";
	}

	@RequestMapping(value = "/person/new", method = RequestMethod.GET)
	public String newPerson(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "personNew";
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public String savePerson(Person person) {
		personService.savePerson(person);
		return "redirect:/people";
	}

	@RequestMapping("/person/delete/{id}")
	public String delete(@PathVariable Integer id) {
		personService.deletePerson(id);
		return "redirect:/people";
	}
}
