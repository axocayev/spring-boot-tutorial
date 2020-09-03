package atl.academy.mvc.thymleaf.demo.entity;

import atl.academy.mvc.thymleaf.demo.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Objects;


@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Test {
    @ToString.Exclude
    private final double vl = 1.5;

    private String test1;
    private String test2;
    private double dbl;

    public double getDbl() {
        return dbl * vl;
    }

    @Override
    public String toString() {
        return "Test{" +
                "test1='" + test1 + '\'' +
                ", test2='" + test2 + '\'' +
                ", dbl=" + dbl +
                '}';
    }

    public static void main(String[] args) {

        BookDto bookDto=new BookDto();
        bookDto.setId(1L);

        System.out.println(bookDto);

        ExceptionCheck  exceptionCheck=new ExceptionCheck();

        System.out.println(exceptionCheck.testConvert("15"));


        Test t = new Test("test1", "test2", 5.5);
        Test t1 = new Test("test1", "test2", 5.5);
        t.setDbl(25);
        System.out.println(t);
        System.out.println(t1);
       /* System.out.println(t.hashCode());
        System.out.println(t1.hashCode());
        System.out.println(t1.equals(t));

        BuilderTest builderTest = BuilderTest
                .builder()
                .email("anarxocayev@qmil.com")
                .id(15)
                .name("Anar Xocayev")
                .phon("+994556112116").build();
        System.out.println(builderTest.toString());
*/

    }
}

