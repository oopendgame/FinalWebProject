package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import WebPackage.challenge.currQuizInfo;

public class currQuizTests {

		@Test
		void test1() {
			String i = "0";
			String j = "1";
			currQuizInfo cq = new currQuizInfo();
			cq.setId(i);
			assertEquals(cq.getId(), i);
			assertNotEquals(j, cq.getId());
		}
}
