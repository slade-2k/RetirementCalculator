import java.io.*;
import java.util.*;

public class RetirementCalculator {
	public static void main (String args[]){
		RetirementCalculator retireCalc = new RetirementCalculator();
		retireCalc.calculation();
		
	}
	
	private void calculation() {
		InputStream inputStream = System.in;
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(inputStream));
		int exceptionChecker = 1;
		Calendar calendar = Calendar.getInstance();
		
		do {
			try {
				int currentAge = getUserInput("What is your current age? ", buffRead);
				int retireAge = getUserInput("At what age would you like to retire? ", buffRead);
				int timeToRetire = retireAge - currentAge;
				
				if(currentAge<0 || retireAge <=0)
				{
					System.out.println("You can't be younger than 0. Please retype you age.\n");
					continue;
				}
				
				if (timeToRetire > 0) {
					System.out.println("You have "+timeToRetire+" years left until you can retire.");
					System.out.println("It's "+ calendar.get(Calendar.YEAR) + ", so you can retire in "+ (calendar.get(Calendar.YEAR)+timeToRetire) + ".");
				}
				else if (timeToRetire==0) {
					System.out.println("Congratulations you did it! Go get retired!");
				}
				else {
					System.out.println("You should have been retired by now!");
				}
				
				exceptionChecker = 0;
			} catch (Exception e) {
				System.out.println("Something went wrong. Program is restarting.\n");
			}
		} while(exceptionChecker == 1);
	}
	
	private int getUserInput(String message, BufferedReader buffRead) throws Exception{
		System.out.print(message);
		return Integer.parseInt(buffRead.readLine());
	}
}