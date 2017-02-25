package java8practice;

import java.io.IOException;
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
	}

}
