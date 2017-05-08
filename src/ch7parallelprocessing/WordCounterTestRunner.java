package ch7parallelprocessing;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounterTestRunner {

	public static void main(String[] args){

		final String SENTENCE = " Nel    mezzo del cammin   di nostra  vita " +
				"mi ritrovai in una  selva oscura" +
				" che la  dritta via era  smarrita ";
		
//		Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
		
		Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> stream = StreamSupport.stream(spliterator, true);
		
		System.out.println("Found " + WordCounter.countWords(stream) + " words");
	}

}
