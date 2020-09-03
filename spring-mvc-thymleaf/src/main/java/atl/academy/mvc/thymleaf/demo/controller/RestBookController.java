package atl.academy.mvc.thymleaf.demo.controller;


import atl.academy.mvc.thymleaf.demo.entity.Book;
import atl.academy.mvc.thymleaf.demo.exception.BookNotFound;
import atl.academy.mvc.thymleaf.demo.request.BookRequest;
import atl.academy.mvc.thymleaf.demo.response.BaseResponse;
import atl.academy.mvc.thymleaf.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController            //:port/book?id=2
@RequestMapping("/api/v1")  ///:port/api/v1/book?id=2
public class RestBookController {

    private BookService bookService;

    public RestBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = {"/book"}, method = RequestMethod.GET)
    public BaseResponse bookById(@RequestParam("id") Long id) {
        /*Book book = bookService.getBookById(id);
        System.out.println(book);
        return book;*/

        return bookService.getBookByIdWithOptional(id);
    }
    @RequestMapping(value = {"/book/list"}, method = RequestMethod.GET)
    public BaseResponse bookById() {

        return bookService.getBookList();
    }


    @RequestMapping(value = {"/book"}, method = RequestMethod.POST)
    public BaseResponse saveBook(@RequestBody BookRequest bookRequest) {
        /*Book book = bookService.getBookById(id);
        System.out.println(book);
        return book;*/

        return bookService.saveBook(bookRequest);
    }


}
