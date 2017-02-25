package java8practice;

import java.util.ArrayList;
import java.util.List;

public class Apple {

	private String color;
	private Integer weight;
	
	public static String inventoryToString(List<Apple> inventory){
		String result = "Apple Inventory \n";
		for (Apple apple: inventory){
			result += apple.getColor() + "\n";
		}
		return result;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Apple(){
	}
	
	public Apple(String color, int weight){
		this.color = color;
		this.weight = weight;
	}
	
	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>();
		for (Apple apple: inventory){
			if (apple.getColor().equals(color))
			result.add(apple);
		}
		return result;
	}
	
	@Override
	public String toString(){
		return "[color: " + color + ", weight: " + weight + "]";
	}
	
	public static void prettyPrintApple(List<Apple> inventory, ApplePrintFilter printFilter){
		System.out.println(printFilter.getFilterHeader());
		for (Apple apple: inventory) {
			String output = printFilter.getFilteredPrint(apple);
			System.out.println(output);
		}
	}
}
