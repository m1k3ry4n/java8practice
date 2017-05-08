package ch7parallelprocessing;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamUtility {


	public static long iterativeSum(long n){
		long result = 0;
		for (long i = 1L; i <= n; i++){
			result += i;
		}
		return result;
	}

	/**
	 * Accept a number n and return the sum of all the numbers from 1 to n
	 * by generating an infinite stream of numbers limited by n.
	 */
	public static long sequentialSum(long n){
		return Stream.iterate(1L, i->i+1) // generate the infinite stream of natural numbers
				.limit(n) // limit it to the first n numbers
				.reduce(0L,  Long::sum); // reduce the stream by summing all the numbers
	}

	/**
	 * Do everything in sequentialSum, but do it in parallel
	 * @param n
	 * @return
	 */
	public static long parallelSum(long n){
		return Stream.iterate(1L, i->i+1) // generate the infinite stream of natural numbers
				.limit(n) // limit it to the first n numbers
				.parallel() // create a parallel stream
				.reduce(0L,  Long::sum); // reduce the stream by summing all the numbers
	}

	public static long rangedSum(long n){
		return LongStream.rangeClosed(1, n)
				.reduce(0L, Long::sum);
	}
	
	public static long parallelRangedSum(long n){
		return LongStream.rangeClosed(1, n)
				.parallel()
				.reduce(0L, Long::sum);
	}
	
	public static long sideEffectSum(long n){
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n).forEach(accumulator::add);
		return accumulator.total;
	}
	
	public static long sideEffectParallelSum(long n){
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
		return accumulator.total;
	}
	
	public static long forkJoinSum(long n){
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		return new ForkJoinPool().invoke(task);
	}
}
