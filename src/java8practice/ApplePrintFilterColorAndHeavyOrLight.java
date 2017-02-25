package java8practice;

public class ApplePrintFilterColorAndHeavyOrLight implements ApplePrintFilter{

	@Override
	public String getFilteredPrint(Apple apple) {
		
		String color = apple.getColor();
		String heavyOrLight = apple.getWeight() < 150 ? "light" : "heavy";
		
		return "Color: " + color + ", " + heavyOrLight;
	}

	@Override
	public String getFilterHeader() {
		return "Colors and Light or Heavy";
	}

}
