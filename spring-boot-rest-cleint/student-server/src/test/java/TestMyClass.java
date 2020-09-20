import atl.acadamey.studentserver.MyClass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyClass {
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        MyClass tester = new MyClass(); // MyClass is tested
        assertEquals(0, tester.multiple(10, 0), "10 x 0 must be 0");
        assertEquals(0, tester.multiple(0, 10), "0 x 10 must be 0");
        assertEquals(0, tester.multiple(0, 0), "0 x 0 must be 0");
        assertEquals(3, tester.multiple(1, 3), "1 x 3 must be 3");
    }
}
