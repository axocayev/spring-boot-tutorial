package atl.academy.mvc.thymleaf.demo.exception;

public class BookNotFound extends RuntimeException{
    public BookNotFound(Long id){
        super("Book not found whit ID :"+id);
    }
}
