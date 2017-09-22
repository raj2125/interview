import java.math.BigInteger;

/**
 * @see https://en.wikipedia.org/wiki/Luhn_algorithm#Description
 */
public class Luhn {

	/**
	 * TODO
	 * 
	 * Accepts a card number and determines if the card number is a valid number
	 * with respect to the Luhn algorithm.
	 * 
	 * @param cardNumber
	 *            the card number
	 * 
	 * @return true if the card number is valid according to the Luhn algorithm,
	 *         false if not
	 */
	// #2 Implement isValidLuhn
	public boolean isValidLuhn(BigInteger cardNumber) {
		boolean doubleDigit = true;
		int sum = 0;
		//BigInteger cardNum = BigInteger.ZERO;
		BigInteger cardNum = null ;

		BigInteger modNumber = BigInteger.TEN;
		long checkDigit=0;
		int calculatedCheckDigit=0;

		System.out.println("Validate Number:" + cardNumber);

		if(cardNumber.intValue() > 0){
			 checkDigit = cardNumber.intValue() % 10;
			System.out.println("cardNumber: " + cardNumber);
			System.out.println("modNumber: " + modNumber);
			 //cardNum = cardNumber.longValue() / 10;
			//cardNum = cardNumber.mod(modNumber);
			cardNum = cardNumber.divide(modNumber);


			System.out.println("checkDigit: " + checkDigit);
			System.out.println("cardNum: " + (cardNum));
		}
		while (cardNum.intValue() > 0) {
			//long digit = cardNum % 10;
			long digit = cardNum.intValue() % 10;


			if (doubleDigit) { // double the value of every second digit
				digit *= 2;

				// if two digits, use  the sum of the digits
				if (digit > 10) {
					digit = digit / 10 + digit % 10;
				}
			}
			doubleDigit = !doubleDigit;

			sum += digit;

			//cardNum /= 10; // remaining digits to the left
			cardNum = cardNum.mod(modNumber);;
		}
		calculatedCheckDigit = (sum * 9 % 10);
		System.out.println("calculatedCheckDigit: " + calculatedCheckDigit);

		if(calculatedCheckDigit == checkDigit)
		{
			System.out.println("Valid Luhn:" + cardNumber);
			return true;
		}

		return false;
	}

/*

	public boolean isValidLuhn(long cardNumber) {
		boolean doubleDigit = true;
		int sum = 0;
		long cardNum=0;
		long checkDigit=0;
		int calculatedCheckDigit=0;

		System.out.println("Validate Number:" + cardNumber);

		if(cardNumber > 0){
			checkDigit = cardNumber % 10;
			cardNum = cardNumber / 10;
			System.out.println("checkDigit: " + checkDigit);
			System.out.println("cardNum: " + cardNum);
		}
		while (cardNum > 0) {
			long digit = cardNum % 10;


			if (doubleDigit) { // double the value of every second digit
				digit *= 2;

				// if two digits, use  the sum of the digits
				if (digit > 10) {
					digit = digit / 10 + digit % 10;
				}
			}
			doubleDigit = !doubleDigit;

			sum += digit;

			cardNum /= 10; // remaining digits to the left
		}
		calculatedCheckDigit = (sum * 9 % 10);
		System.out.println("calculatedCheckDigit: " + calculatedCheckDigit);

		if(calculatedCheckDigit == checkDigit)
		{
			System.out.println("Valid Luhn:" + cardNumber);
			return true;
		}

		return false;
	}
	*/

	// #3. Implement countRange
	/**
	 * Accepts a partial card number (excluding the last digit) and generates
	 * the appropriate Luhn check digit for the number.
	 * 
	 * @param cardNumber
	 *            the card number (not including a check digit)
	 * 
	 * @return the check digit
	 */
	public int generateCheckDigit(int cardNumber) {
		boolean doubleDigit = true;
		int sum = 0;
		while (cardNumber > 0) {
			// starting from the right (rightmost is the unknown check digit)
			long digit = cardNumber % 10; 

			if (doubleDigit) { // double the value of every second digit
				digit *= 2;

				// if two digits, use the sum of the digits
				if (digit > 10) {
					digit = digit / 10 + digit % 10; 
				}
			}
			doubleDigit = !doubleDigit;

			sum += digit;

			cardNumber /= 10; // remaining digits to the left
		}

		return sum * 9 % 10;
	}

	/**
	 * TODO
	 * 
	 * Accepts two card numbers representing the starting and ending numbers of
	 * a range of card numbers and counts the number of valid Luhn card numbers
	 * that exist in the range, inclusive.
	 * 
	 * @param startRange
	 *            the starting card number of the range (may not be valid luhn)
	 * @param endRange
	 *            the ending card number of the range (may not be a valid luhn)
	 * 
	 * @return the number of valid Luhn card numbers in the range, inclusive
	 */
	public int countRange(int startRange, int endRange) {

		System.out.println("startRange:" + startRange + " endRange: " + endRange );
		int countLuhnCardNumbers = 0;

		for(int cardNumber = startRange; cardNumber <= endRange; cardNumber++){
			System.out.println(cardNumber);
//			if(isValidLuhn(cardNumber)){
//				countLuhnCardNumbers += 1;
//			}
		}
		System.out.println("countLuhnCardNumbers:" + countLuhnCardNumbers);

		return countLuhnCardNumbers;
	}
}
