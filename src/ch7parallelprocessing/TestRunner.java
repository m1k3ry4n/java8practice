package ch7parallelprocessing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class TestRunner {

	public static void main(String[] args) {
		
		long numNumbersToSum = 10_000_000;
		
		Map<String, Function<Long, Long>> methodMap = new HashMap<>();
		methodMap.put("Iterative",StreamUtility::iterativeSum);
		methodMap.put("Sequential",StreamUtility::sequentialSum);
		methodMap.put("Parallel",StreamUtility::parallelSum);
		methodMap.put("Ranged Sum",StreamUtility::rangedSum);
		methodMap.put("Parallel Ranged Sum",StreamUtility::parallelRangedSum);
		methodMap.put("Side Effects",StreamUtility::sideEffectSum);
		methodMap.put("Side Effects Parallel Sum",StreamUtility::sideEffectParallelSum);
		methodMap.put("ForkJoinSum",StreamUtility::forkJoinSum);
		
		for (Entry<String, Function<Long, Long>> entrySet: methodMap.entrySet()){
			System.out.println(entrySet.getKey() + " done in: " + 
					PerformanceMeasurer.measureSumPerf(entrySet.getValue(), numNumbersToSum)
					+ " msecs");
		}
		
		
	}
}