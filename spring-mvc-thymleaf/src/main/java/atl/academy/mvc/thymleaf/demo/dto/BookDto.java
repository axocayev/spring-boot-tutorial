package atl.academy.mvc.thymleaf.demo.dto;


import atl.academy.mvc.thymleaf.demo.entity.Author;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class BookDto {
    private Long id;
    private String name;

    private String genre;
    private String status; //1 => Available, 0=> Not Available
    private String created;
    private String updated;
    private String publisher;
    private String publishYear;
    private Author author;


}
