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
		BigInteger cardNum = null ;
		BigInteger modNumber = BigInteger.TEN;
		long checkDigit=0;
		long calculatedCheckDigit=0;

		System.out.println("Validate Number:" + cardNumber);

		// Process Giftcards
		if(cardNumber.bitLength() > 62) {
			boolean isGiftCard = isValidGiftCard(cardNumber);
			if(isGiftCard){ return true;
			} else {
				return  false;
			}
		}

		if(cardNumber.longValueExact() > 0){
			checkDigit = cardNumber.longValueExact() % 10;
			cardNum = cardNumber.divide(modNumber);
//			System.out.println("checkDigit: " + checkDigit);
//			System.out.println("cardNum: " + (cardNum));
//			System.out.println("cardNum longValueExact:" + cardNum.longValueExact());

		}
		while (cardNum.longValueExact() > 0) {
			long digit = cardNum.longValueExact() % 10;

			if (doubleDigit) { // double the value of every second digit
				digit *= 2;

				// if two digits, use  the sum of the digits
				if (digit > 10) {
					digit = digit / 10 + digit % 10;
				}
			}
			doubleDigit = !doubleDigit;
			sum += digit;
			cardNum = cardNum.divide(modNumber);
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



	// #3. Implement countRange
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
	public int countRange(BigInteger startRange, BigInteger endRange) {

		System.out.println("startRange:" + startRange + " endRange: " + endRange );
		int countLuhnCardNumbers = 0;

		while  ((startRange.compareTo(endRange)) == -1 || (startRange.compareTo(endRange)) == 0){

			if(isValidLuhn(startRange)){
				countLuhnCardNumbers += 1;
			}
			System.out.println("countLuhnCardNumbers:" + countLuhnCardNumbers);
			startRange = startRange.add(BigInteger.ONE);
			System.out.println(startRange.toString());

		}

		System.out.println("countLuhnCardNumbers:" + countLuhnCardNumbers);

		return countLuhnCardNumbers;
	}

	/**
	 * Accepts a card number (26 & over ) and check if the card number is a valid Luhn Number
	 * valid Luhn Number
	 *
	 * @param cardNumber
	 *            the card number ( including a check digit)
	 *
	 * @return true if the card number is valid according to the Luhn algorithm,
	 *         false if not
	 */

	public boolean isValidGiftCard(BigInteger cardNumber) {

		boolean doubleDigit = true;
		int sum = 0;
		BigInteger cardNum = null ;
		BigInteger checkDigitInteger =BigInteger.ONE;
		BigInteger modNumber = BigInteger.TEN;
		BigInteger digit  = BigInteger.ONE;
		long calculatedCheckDigit=0;
		checkDigitInteger = cardNumber.mod(modNumber);

		System.out.println("Gift Card Processing");
		System.out.println("checkDigitInteger: " + checkDigitInteger.intValue());

		cardNum = cardNumber.divide(modNumber);
		System.out.println("cardNum: " + (cardNum));
		int intDigit =0;

		while (cardNum.bitLength() > 0) {
			digit = cardNum.mod(modNumber);
			if (doubleDigit) { // double the value of every second digit
				intDigit= digit.intValue();
				intDigit *= 2;

				// if two digits, use  the sum of the digits
				if (intDigit > 10) {
					intDigit = intDigit / 10 + intDigit % 10;
				}
			}
			doubleDigit = !doubleDigit;
			sum += intDigit;
			cardNum = cardNum.divide(modNumber);
			//System.out.println("sum: " + (sum));
		}

		calculatedCheckDigit = (sum * 9 % 10);
		System.out.println("calculatedCheckDigit: " + calculatedCheckDigit);
		if(calculatedCheckDigit == checkDigitInteger.intValue())
		{
			System.out.println("Valid Luhn:" + cardNumber);
			return true;
		}

		return false;

	}

}


