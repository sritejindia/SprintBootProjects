package tej.springboot.interceptors.DemoSpringBootInterceptors.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tej.springboot.interceptors.DemoSpringBootInterceptors.model.Book;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {

    private static Map<Integer, Book> bookStore = new HashMap<>();

    static {
        Book book1 = new Book(123, "Alice in Wonderland", "Lewis Carrol");
        bookStore.put(book1.getId(), book1);

        Book book2 = new Book(456, "Anna Karenina", "Leo Tolstoy");
        bookStore.put(book2.getId(), book2);
    }

    @RequestMapping("/")
    public String welcome() {
        return "<h2>Welcome to the bookstore</h2>";
    }

    @RequestMapping("/book")
    public ResponseEntity<Object> getBook(@RequestParam("bookId") Integer bookId) {
        System.out.println("Retrieving book...");
        return new ResponseEntity<>(bookStore.get(bookId), HttpStatus.OK);
    }

}
