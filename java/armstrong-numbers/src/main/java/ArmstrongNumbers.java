import java.util.*;


class ArmstrongNumbers {

	boolean isArmstrongNumber(int number) {
		if (number < 0)
			throw new IllegalArgumentException();
		List<Integer> digits = getListOfDigits(number);
		int numDigits = digits.size();
		long armstrong = 0;
		for (int digit : digits) {
			armstrong += powAsLong(digit, numDigits);
			if (armstrong > number)
				return false;
		}
		return armstrong == number;
	}

	static long powAsLong(int n, int exp) {
		// Naive pow. 
		// 1 <= exp <= 10
		long result = n;
		for (int i=1; i<exp; i++)
			result *= n;
		return result;
	}

	static List<Integer> getListOfDigits(int number) {
		List<Integer> digits = new ArrayList<>();
		while (number > 0) {
			digits.add(number % 10);
			number /= 10;
		}
		return digits;
	}

}
