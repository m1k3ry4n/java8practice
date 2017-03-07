package java8practice;

import java.io.IOException;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;

public class TestRunner {

	public static void main(String[] args) throws IOException {
		List<Apple> inventory = AppleFactory.makeApples();
		System.out.println(inventory.toString());
		List<Apple> greenApples = Apple.filterApplesByColor(inventory, "green");
		System.out.println("Green Apples: " + greenApples.toString());
		
		Apple.prettyPrintApple(inventory, new ApplePrintFilterColor());
		Apple.prettyPrintApple(inventory, new ApplePrintFilterWeight());
		Apple.prettyPrintApple(inventory, new ApplePrintFilterColorAndHeavyOrLight());
		
		inventory.sort(new AppleComparator());
		
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2){
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		
		inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		
		Comparator<Apple> c = comparing((Apple a) -> a.getWeight());
		
		// final solution
		inventory.sort(comparing(Apple::getWeight));
	}

}
