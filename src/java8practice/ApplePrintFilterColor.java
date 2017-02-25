package java8practice;

public class ApplePrintFilterColor implements ApplePrintFilter {

	@Override
	public String getFilteredPrint(Apple apple) {
		return apple.getColor();
	}

	@Override
	public String getFilterHeader() {
		return "Colors";
	}

}
