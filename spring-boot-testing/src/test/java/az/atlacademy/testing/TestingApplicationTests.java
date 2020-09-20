package az.atlacademy.testing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
class TestingApplicationTests {
  EvenOddNumbers evenOddNumbers=new EvenOddNumbers();
	@Test
	void testMyClass() {
		assertEquals(true,evenOddNumbers.isEven(2));
		assertEquals(false,evenOddNumbers.isEven(5));
		assertEquals(false,evenOddNumbers.isEven(-6));
	}



}
