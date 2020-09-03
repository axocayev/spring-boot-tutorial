package atl.academy.mvc.thymleaf.demo.controller;


import atl.academy.mvc.thymleaf.demo.exception.BookNotFound;
import atl.academy.mvc.thymleaf.demo.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookControllerHandler {

    @ResponseBody
    @ExceptionHandler(BookNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse getNotFoundExceptionMessage(BookNotFound bookNotFound){
        BaseResponse baseResponse=new BaseResponse("NOT FOUND");
        baseResponse.setMessage(bookNotFound.getMessage());
        return baseResponse;
    }
}

