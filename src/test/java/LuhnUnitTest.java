import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class LuhnUnitTest {

	Luhn luhn;

	@Before
	public void setUp() throws Exception {
		luhn = new Luhn();
	}

	@Test
	public void generateCheckDigit() {

		assertEquals(9, luhn.generateCheckDigit(92739871));
	}

	@Test
	public void isValidLuhn() {
//		assertFalse(luhn.isValidLuhn(new BigInteger("927398710")));
//		assertFalse(luhn.isValidLuhn(new BigInteger("927398711")));
//		assertFalse(luhn.isValidLuhn(new BigInteger("927398712")));
//		assertFalse(luhn.isValidLuhn(new BigInteger("927398713")));
//		assertFalse(luhn.isValidLuhn(new BigInteger("927398714")));
//		assertFalse(luhn.isValidLuhn(new BigInteger("927398715")));
//		assertFalse(luhn.isValidLuhn(new BigInteger("927398716")));
//		assertFalse(luhn.isValidLuhn(new BigInteger("927398717")));
//		assertFalse(luhn.isValidLuhn(new BigInteger("927398718")));
//		assertTrue(luhn.isValidLuhn(new BigInteger("927398719")));
		assertTrue(luhn.isValidLuhn(new BigInteger("927398727")));
//
//		// #4 Support real-world credit card numbers
//		assertTrue(luhn.isValidLuhn(new BigInteger("4716359405683423")));
//		assertTrue(luhn.isValidLuhn(new BigInteger("4716359405683423")));
//		assertTrue(luhn.isValidLuhn(new BigInteger("344483310930006")));
//		assertFalse(luhn.isValidLuhn(new BigInteger("4976444957945142")));
//
//		// #5. Support even longer gift-card numbers
//		assertTrue(luhn.isValidLuhn(new BigInteger("7261022874914782621166821566")));



	}

	@Test
	public void countRange() {
		assertEquals(1,luhn.countRange(927398710,927398720));
		assertEquals(2,luhn.countRange(927398710,927398730));

		//assertEquals(1,luhn.countRange(7261022874914782621166821566L,7261022874914782621166821569L));

	}

}
