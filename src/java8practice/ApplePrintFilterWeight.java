package java8practice;

public class ApplePrintFilterWeight implements ApplePrintFilter {

	@Override
	public String getFilteredPrint(Apple apple) {
		return apple.getWeight().toString();
	}

	@Override
	public String getFilterHeader() {
		return "Weight";
	}

}
