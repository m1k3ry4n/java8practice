package collectors;

public class TestRunner {

	public static void main(String[] args) {
		
		int candidate = ioUtility.getNextIntFromInput();

		System.out.println("Is " + candidate + " prime? " + primeUtility.isPrime(candidate));

	}
}
