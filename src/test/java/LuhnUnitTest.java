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
		assertFalse(luhn.isValidLuhn(new BigInteger("927398710")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398711")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398712")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398713")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398714")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398715")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398716")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398717")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398718")));
		assertTrue(luhn.isValidLuhn(new BigInteger("927398719")));
		assertTrue(luhn.isValidLuhn(new BigInteger("927398727")));

		// #4 Support real-world credit card numbers
		assertTrue(luhn.isValidLuhn(new BigInteger("4716359405683423")));
		assertTrue(luhn.isValidLuhn(new BigInteger("4716359405683423")));
		//Valid 16 digit card number
		assertTrue(luhn.isValidLuhn(new BigInteger("344483310930006")));
		//Valid 18 digit card number
		assertTrue(luhn.isValidLuhn(new BigInteger("923972729813481117")));
		//Valid 19 digit card number
		assertTrue(luhn.isValidLuhn(new BigInteger("4316360149636387636")));

//
//		//Valid 20 digit card number
//		assertTrue(luhn.isValidLuhn(new BigInteger("67737670972664412737")));
//
//		//Valid 26 digit card number
//		assertTrue(luhn.isValidLuhn(new BigInteger("32524676369258844730545913")));
//
//		assertFalse(luhn.isValidLuhn(new BigInteger("4976444957945142")));
//
//		// #5. Support even longer gift-card numbers: 28 digit card number
//		assertTrue(luhn.isValidLuhn(new BigInteger("7261022874914782621166821566")));
//		assertTrue(luhn.isValidLuhn(new BigInteger("4045154793804310038712630156")));
//


	}

	@Test
	public void countRange() {
		assertEquals(1,luhn.countRange(new BigInteger("927398710"), new BigInteger("927398720")));
		assertEquals(2,luhn.countRange(new BigInteger("927398710"), new BigInteger("927398730")));

	}

}
