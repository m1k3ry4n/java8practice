package collectors;

import java.util.List;
import java.util.Map;

public class TestRunner {

	public static void main(String[] args) {
		
		int candidate = ioUtility.getNextIntFromInput();

		Map<Boolean, List<Integer>> primeNumbersMap	= primeUtility.partitionPrimesWithCustomCollector(candidate);
		
		System.out.println(primeNumbersMap.toString());

	}
}
