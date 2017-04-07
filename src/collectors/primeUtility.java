package collectors;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;
import java.util.stream.IntStream;

public class primeUtility {

	public static boolean isPrime(int candidate){
		return IntStream.range(2, candidate)
				.noneMatch(i -> candidate % i == 0);
	}
	
	public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed()
				.collect(partitioningBy(candidate -> isPrime(candidate)));
	}
	
	public static boolean isPrimeImproved(int candidate){
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return IntStream.rangeClosed(2,  candidateRoot)
				.noneMatch(i -> candidate % i == 0);
	}
	
	public static <A> List<A> takeWhile(List<A> list, Predicate<A> p){
		int i=0;
		for (A item : list){
			if (!p.test(item)){
				return list.subList(0, i);
			}
			i++;
		}
		return list;
	}
	
	//TODO
//	public static List<Integer> getListOfPrimes(int rangeLow, int rangeHigh){
//		
//		IntStream.range(rangeLow, rangeHigh).filter(i->)
//	}
}
