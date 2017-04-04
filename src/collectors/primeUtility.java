package collectors;

import java.util.List;
import java.util.stream.IntStream;

public class primeUtility {

	public static boolean isPrime(int candidate){
		return IntStream.range(2, candidate)
				.noneMatch(i -> candidate % i == 0);
	}
	
	public static List<Integer> getListOfPrimes(int rangeLow, int rangeHigh){
		
		IntStream.range(rangeLow, rangeHigh).filter(i->)
	}
}
