package atl.academy.mvc.thymleaf.demo.service;

import atl.academy.mvc.thymleaf.demo.entity.Book;
import atl.academy.mvc.thymleaf.demo.exception.BookNotFound;
import atl.academy.mvc.thymleaf.demo.mapper.BookMapper;
import atl.academy.mvc.thymleaf.demo.repository.BookRepository;
import atl.academy.mvc.thymleaf.demo.request.BookRequest;
import atl.academy.mvc.thymleaf.demo.response.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();

        /* List<Double > x=new ArrayList<>();
         x.add(15.2);
         x.add(22.5);
         x.add(33.5);
         double sum=x.stream().collect(Collectors.summingDouble(Double::doubleValue));
*/
        /* List<Book> list=new ArrayList<>();
         for(int i=1;i<=10;i++){
             Book book=new Book();
             book.setId((long)i);
             book.setName("Book "+i);
             book.setAuthor("Author "+i);
             book.setGenre("genre"+i);
             Random  random=new Random();
             int r=random.nextInt(2);
             book.setStatus(String.valueOf(r));
             list.add(book);
         }
         return  list;*/
    }

    public Book getBookById(Long id) {
        return bookRepository.getOne(id);
    }


    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deletBookById(Long id) {
        bookRepository.delete(getBookById(id));
    }

    public BaseResponse getBookByIdWithOptional(Long id) {
        BaseResponse baseResponse = new BaseResponse("SUCCESS");
        baseResponse.setData(bookMapper.convertToDto(bookRepository.findById(id).orElseThrow(() -> new BookNotFound(id))));
        return baseResponse;
    }

    public BaseResponse saveBook(BookRequest bookRequest) {
        BaseResponse baseResponse = new BaseResponse("SUCCESS");

        Book book = bookRepository.save(bookMapper.convertToEntity(bookRequest));

        baseResponse.setData(bookMapper.convertToDto(book));
        return baseResponse;

    }

    public BaseResponse getBookList() {
        BaseResponse baseResponse = new BaseResponse("SUCCESS");
        baseResponse.setData(bookRepository
                .findAll()
                .stream()
                .map(x -> bookMapper.convertToDto(x))
                .collect(Collectors.toList()));
        return baseResponse;

    }
}
