package java8practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestRunnerFI {

	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
		String oneLine = processFile((BufferedReader br) -> br.readLine());
		
		System.out.println("One line: " + oneLine);
		System.out.println("Two lines: " + twoLines);
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("src/java8practice/colors.txt"))){
			return p.process(br);
		}
	}
}
