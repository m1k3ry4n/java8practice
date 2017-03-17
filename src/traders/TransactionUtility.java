package traders;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;

public class TransactionUtility {

	/**
	 * Finds all transactions in the year 2011 and sorts them by value (small to high).
	 * 
	 * @param transactions
	 */
	public static void sorted2011Transactions(List<Transaction> transactions){

		transactions.stream()
		.filter(t -> t.getYear() == 2011)
		.sorted(comparing(Transaction::getValue))
		.forEach((Transaction t) -> System.out.println(t.toString()));

	}
	
	/**
	 * Finds the unique cities where traders live.
	 * 
	 * @param transactions
	 */
	public static void findUniqueCities(List<Transaction> transactions){
		transactions.stream()
		.map(Transaction::getTrader)
		.map(Trader::getCity)
		.distinct()
		.forEach((String city) -> System.out.println(city));
		
	}
	
	/**
	 * Finds all traders from Cambridge and sorts them by name.
	 * 
	 * @param transactions
	 */
	public static void allTradersFromCambridgeSortedByName(List<Transaction> transactions){
		transactions.stream()
		.map(Transaction::getTrader)
		.filter(t -> t.getCity().equals("Cambridge"))
		.sorted(comparing(Trader::getName))
		.forEach((Trader t) -> System.out.println(t));
	}
	
	/**
	 * Returns a comma-delimited String of distinct Traders' names.
	 * 
	 * @param transactions
	 * @return
	 */
	public static String allTradersNames(List<Transaction> transactions){
		return transactions.stream()
		.map(Transaction::getTrader)
		.map(Trader::getName)
		.distinct()
		.sorted(String::compareTo)
		.collect(Collectors.joining(", "));
	}
	
	/**
	 * Determines if there are any traders in Milan.
	 * 
	 * @param transactions
	 * @return
	 */
	public static boolean anyTradersInMilan(List<Transaction> transactions){
		return transactions.stream()
				.map(Transaction::getTrader)
				.anyMatch(t -> t.getCity() == "Milan");
	}
	
	/**
	 * Prints the value of transactions from Cambridge.
	 * 
	 * @param transactions
	 */
	public static void printAllTransactionValuesFromCambridge(List<Transaction> transactions){
		
		System.out.println("All values from Cambridge:");
		transactions.stream()
				.filter(t->t.getTrader().getCity()=="Cambridge")
				.forEach((Transaction t) -> System.out.println(t.getValue()));
	}
	
	/**
	 * Returns highest transaction value.
	 * 
	 * @param transactions
	 * @return
	 */
	public static int getHighestTransactionValue(List<Transaction> transactions){
		return transactions.stream()
				.map(Transaction::getValue)
				.reduce(0,Integer::max);
	}
	
	public static int getLowestTransactionValue(List<Transaction> transactions){
		return transactions.stream()
				.map(Transaction::getValue)
				.reduce(Integer::min)
				.get();
	}
	
}
