package java8practice;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AppleFactory {

	public static List<Apple> makeApples() throws IOException{
		List<String> colors = getColorList();
		List<Apple> inventory = new ArrayList<Apple>();
		for (String color: colors){
			for (int i=1; i<5; i++){
				inventory.add(new Apple(color, i*75));
			}
		}
		return inventory;
	}

	public static List<String> getColorList() throws IOException{
		Path path = FileSystems.getDefault().getPath("/Users/michaelryan/programming/java8/java8practice/src/java8practice", "colors.txt");
		return Files.readAllLines(path);
	}
}
