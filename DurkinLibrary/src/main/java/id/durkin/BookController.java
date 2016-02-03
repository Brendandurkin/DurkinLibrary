package id.durkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import id.durkin.model.Book;
import id.durkin.services.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("books", bookService.listAllBooks());
		return "books";
	}

	@RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, Model model) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "bookEdit";
	}

	@RequestMapping(value = "/book/new", method = RequestMethod.GET)
	public String newBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "bookNew";
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String saveBook(Book book) {
		bookService.saveBook(book);
		return "redirect:/books";
	}

	@RequestMapping("/book/delete/{id}")
	public String delete(@PathVariable Integer id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}
