package collectors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ioUtility {


	public static int getNextIntFromInput(){

		Integer nextInt = null;

		while(nextInt == null){
			System.out.println("Number: ");

			try {
				Scanner scanIn = new Scanner(System.in);
				nextInt = scanIn.nextInt();
				scanIn.close();
			} catch (InputMismatchException ime){
				System.out.println("Please enter an integer. No other values will work");
			}
		}

		return nextInt;
	}
}
