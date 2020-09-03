package atl.academy.mvc.thymleaf.demo.entity;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class BuilderTest {
    private int id;
    private String name;
    private  String email;
    private String phon;

}
