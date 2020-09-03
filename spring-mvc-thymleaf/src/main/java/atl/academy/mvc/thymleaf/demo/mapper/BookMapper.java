package atl.academy.mvc.thymleaf.demo.mapper;

import atl.academy.mvc.thymleaf.demo.dto.BookDto;
import atl.academy.mvc.thymleaf.demo.entity.Author;
import atl.academy.mvc.thymleaf.demo.entity.Book;
import atl.academy.mvc.thymleaf.demo.request.BookRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class BookMapper {

    private ModelMapper modelMapper;

    private final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd");

    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BookDto convertToDto(Book book) {
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        bookDto.setStatus(book.getStatus().equals("1") ? "Available" : "Not Available");
        bookDto.setUpdated(dateFormat.format(book.getUpdatedAt()));

        //bookDto.setAuthorDetail(new Author(1L,"Anar","Xocayev","anarxcoayev@gmail.com","khirdalan"));

        return bookDto;
    }

    public Book convertToEntity(BookRequest bookRequest) {
        Book book = modelMapper.map(bookRequest, Book.class);
       book.setStatus(bookRequest.getStatus().equals("Available")?"1":"0");// ; //1 => Available, 0=> Not Available
        System.out.println(book);
       return  book;
    }
}
