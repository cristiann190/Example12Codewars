package src;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Thirteen {
	private static Map<Integer, Integer> pows = new TreeMap<>();

	public static long thirt(long n) {
		fillPowsMap(n);
		long lastNumber = n;
		boolean keepLooping = true;
		while (keepLooping) {
			final int reducedNumber = sumDigits(lastNumber);
			if (lastNumber == reducedNumber) {
				keepLooping = false;
			} else {
				lastNumber = reducedNumber;
			}
		}
		return lastNumber;
	}

	private static void fillPowsMap(long number) {
		for (int index = pows.size(); index < String.valueOf(number).length(); index++) {
			final double mapValue = Math.pow(10, index) % 13;
			pows.put(index, (int) mapValue);
		}
	}

	private static int sumDigits(long number) {
		int sum = 0;
		final String invertedNumber = new StringBuilder(String.valueOf(number)).reverse().toString();
		for (int index = 0; index < invertedNumber.length(); index++) {
			sum += Character.getNumericValue(invertedNumber.charAt(index)) * pows.get(index);
		}
		return sum;
	}


	//    OPTIMIZED
	private static final int a[] = {1, 10, 9, 12, 3, 4}; //pattern
	public static long thirtOptimized(long n) {
		// New number
		long r = 0;
		//Converting long to String
		String s = new String("" + n);
		for (int i = s.length()-1; i >=0 ; --i)
			r += (s.charAt(i) - '0') * a[(s.length() - i - 1) % 6];
		if (r == n)
			return r;
		return thirt(r);
	}
}
