package atl.academy.mvc.thymleaf.demo.controller;


import atl.academy.mvc.thymleaf.demo.entity.Book;
import atl.academy.mvc.thymleaf.demo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {


    private BookService bookService;

    public PageController(BookService bookService) {
        this.bookService = bookService;
    }

    //@GetMapping({"/", "/hello"})
    @RequestMapping(value = {"/", "/hello"},method = RequestMethod.GET)
    public   String hello(Model model,
                 @RequestParam(value="name", required=false, defaultValue="World") String name)
    {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = {"book/list"},method = RequestMethod.GET)
    public String bookList(Model model)
    {
        //ModelAndView modelAndView=new ModelAndView();
        bookService.getAllBook().stream().forEach(System.out::println);

        model.addAttribute("books", bookService.getAllBook());
        return "book/booklist";
    }
    @RequestMapping(value = {"/book"},method = RequestMethod.GET)
    public String bookById(Model model,@RequestParam("id") Long id )
    {
        //ModelAndView modelAndView=new ModelAndView();
       /* bookService.getAllBook().stream().forEach(System.out::println);
          Book book= bookService.getAllBook()
                  .stream()
                  .filter(b->b.getId().equals(id))
                  .collect(Collectors.toList())
                  .get(0);*/
        Book book=bookService.getBookById(id);
        System.out.println(book);

        model.addAttribute("book", book);
        return "book/book";
    }




    @RequestMapping(value = {"/book/new"},method = RequestMethod.GET)
    public String newBookForm(Model model, @ModelAttribute Book book)
    {

        model.addAttribute("book", book);
        return "book/book-ops";
    }
    @RequestMapping(value = {"/book/update"},method = RequestMethod.GET)
    public String updateBookForm(Model model,@RequestParam("id") Long id )
    {

        Book book=bookService.getBookById(id);
        System.out.println(book);

        model.addAttribute("book", book);
        return "book/book-ops";
    }

    @RequestMapping(value = {"/book/delete"},method = RequestMethod.GET)
    public String deleteBook(@RequestParam("id") Long id )
    {

        bookService.deletBookById(id);

        return "redirect:/book/list";
    }

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String saveBook(Model model,@ModelAttribute Book book ){
       bookService.saveBook(book);

        return "redirect:/book/list";
    }

   /* @RequestMapping(value = {"book/list2"},method = RequestMethod.GET)
    public ModelAndView bookList2()
    {
        ModelAndView modelAndView=new ModelAndView();
        bookService.getAllBook().stream().forEach(System.out::println);

        modelAndView.addObject("books", bookService.getAllBook());
        modelAndView.setViewName("book/booklist");
        return modelAndView ;
    }*/

}
