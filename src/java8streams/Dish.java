package java8streams;

import java.util.Arrays;
import java.util.List;

public class Dish {

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
	
	public Dish (String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	
	public String getName(){
		return name;
	}

	public boolean isVegetarian(){
		return vegetarian;
	}
	
	public int getCalories(){
		return calories;
	}
	
	public Type getType(){
		return type;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public enum Type { MEAT, FISH, OTHER }
	
	public static List<Dish> buildDishList(){
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Type.MEAT),
				new Dish("beef", false, 800, Type.MEAT),
				new Dish("chicken", false, 800, Type.MEAT),
				new Dish("french fries", true, 800, Type.MEAT),
				new Dish("rice", true, 800, Type.MEAT),
				new Dish("season fruit", true, 800, Type.MEAT),
				new Dish("pizza", true, 800, Type.MEAT),
				new Dish("prawns", false, 800, Type.MEAT),
				new Dish("salmon", false, 800, Type.MEAT) );
		
		return menu;
				
	}
}
