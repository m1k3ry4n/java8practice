package traders;

import java.util.Arrays;
import java.util.List;

public class TestRunner {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
		
		System.out.println("Sorted 2011 Transactions");
		TransactionUtility.sorted2011Transactions(transactions);
		
		System.out.println();
		
		System.out.println("Unique Cities");
		TransactionUtility.findUniqueCities(transactions);
		
		System.out.println();
		
		System.out.println("Traders from Cambridge");
		TransactionUtility.allTradersFromCambridgeSortedByName(transactions);
		
		System.out.println();
		
		System.out.println("String of Traders' names");
		System.out.println(TransactionUtility.allTradersNames(transactions));
		
		System.out.println();
		System.out.println("Are there any Traders in Milan? " + TransactionUtility.anyTradersInMilan(transactions));
		
		System.out.println();
		TransactionUtility.printAllTransactionValuesFromCambridge(transactions);
		
		System.out.println();
		System.out.println("Highest transaction value: " + TransactionUtility.getHighestTransactionValue(transactions));
		
		System.out.println();
		System.out.println("Lowest transaction value: " + TransactionUtility.getLowestTransactionValue(transactions));
	}

}
