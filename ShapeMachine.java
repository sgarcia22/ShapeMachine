/*Name: Samantha Garcia
 *Date: October 11, 2016
 *Description: This program uses loops and a switch statement to help the user find out the area and perimeter of a specific shape. 
 *Before this, however, they must enter the correct date in order to be allowed into the system; this was possible with the 
 *SimpleDateFormat command along with a for loop.
 *
 *This was a school project.
 */

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Math;

public class ShapeMachine {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Shape Machine login");
		System.out.println();
		System.out.print("What is today's day? "); 
		String day = in.next();
		System.out.print("What is today's month? ");
		String month = in.next();
		System.out.print("What is today's year?");
		String year = in.next();
		
		//To compare the date given, I use the SimpleDateFormat and the .equals function. 
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		String userDate = (day + "-" + month + "-" + year);
		
		//For loop used to count the number of tries and throw the user out of the system if they exceed that amount.
		for (int i = 1; i <= 3; i++) {
			if (userDate.equals(date)) {
				System.out.println(" Correct date. Welcome! ");
				break;
			}
			else if (i == 3) {
				System.out.println(" #ERROR 3rd invalid login attempt. Terminating program.");
				System.out.println();
				System.exit(0);
			}
			else {
					System.out.println("#ERROR Login attempt #" + i + " Invalid input. Please try again. ");
					System.out.println();
					System.out.print("What is today's day? "); 
					day = in.next();
					System.out.print("What is today's month? ");
					month = in.next();
					System.out.print("What is today's year?");
					year = in.next();
					userDate = (day + "-" + month + "-" + year);
			}

		}
		
		while (true) {
		System.out.println("---Welcome to the Shape Machine---");
		System.out.println("Available Options: ");
		System.out.println("Circles" );
		System.out.println("Rectangles");
		System.out.println("Triangles");
		System.out.println("Exit");
		String option = in.next();
		
		boolean optionFalse = false;
		
		//I used a while loop to check if they entered a correct String above. 
		while (optionFalse == false) {
			if (option.equals("Circles") || option.equals("Rectangles") || option.equals("Triangles") || option.equals("Exit")) {
				optionFalse = true;
			}
			else {
					System.out.println("#ERROR Invalid option. Please try again. ");
					System.out.println("---Welcome to the Shape Machine---");
					System.out.println("Available Options: ");
					System.out.println("Circles" );
					System.out.println("Rectangles");
					System.out.println("Triangles");
					System.out.println("Exit");
					option = in.next();
			}
		}
		
		//This switch is the most effective way to transition into the selected input. 
		switch (option) {
		
			case "Circles": 
				System.out.print("Circles selected. Please enter the radius: ");
				double radius = in.nextDouble();
				while (radius < 0) {
					System.out.print("#ERROR Negative input. Please input the radius again: ");
					radius = in.nextDouble();
				}
				//I convert the perimeter and area values into a string and then take their length in order to find the number of characters in the answer.
				double circleCum = (2 * Math.PI * radius);
				String circleCumChar = Double.toString(circleCum);
				int circleCumCharLength = circleCumChar.length();
				double circleArea = (Math.PI * radius * radius);
				String areaChar = Double.toString(circleArea);
				int circleAreaCharLength = areaChar.length();
				
				System.out.println("The circumference is: " + circleCum);
				System.out.println("The area is: " + circleArea);
				System.out.println("Total number of digits in the circumference is: " + (circleCumCharLength - 1));
				System.out.println("Total number of digits in the area is: " + (circleAreaCharLength - 1));
				continue;
			
			case "Rectangles":
				System.out.print("Rectangles selected. Please enter the 2 sides: ");
				double side1 = in.nextDouble();
				double side2 = in.nextDouble();
				while (side1 < 0 || side2 <0) {
					System.out.print("#ERROR Negative input. Please input the 2 sides again: ");
					side1 = in.nextDouble();
					side2 = in.nextDouble();
				}
				double recArea = (side1 * side2);
				String recAreaChar = Double.toString(recArea);
				int recAreaCharLength = recAreaChar.length();
				double recPer = ((2 * side1) + (2 * side2));
				String recPerChar = Double.toString(recPer);
				int recPerCharLength = recPerChar.length();
				
				System.out.println("The area is: " + recArea);
				System.out.println("The perimeter is: " + recPer);
				System.out.println("Total number of digits in the area is: " + (recAreaCharLength - 1));
				System.out.println("Total number of digits in the perimeter is: " + (recPerCharLength -1));
				continue;
				
			case "Triangles":
				System.out.print("Triangles selected. Please enter the 3 sides: ");
				double side3 = in.nextDouble();
				double side4 = in.nextDouble();
				double side5 = in.nextDouble();
				while (side3 < 0 || side4 <0 || side5 < 0) {
					System.out.print("#ERROR Negative input. Please input the 3 sides again: ");
					side3 = in.nextDouble();
					side4 = in.nextDouble();
					side5 = in.nextDouble();
				}

				if ((side3 + side4 < side5) || (side3 + side5 < side4) || (side4 + side5 <side3)) {
					System.out.println("#ERROR Triangle is not valid. Returning to menu. ");
					System.out.println();
					//The continue function takes the user to the start of the while loop. 
					continue;
					
					
				}
				boolean scalene = false;
				boolean equilateral = false;
				boolean isoceles = false; 
				String triType;
				double triHeight;
				
				//Here I used an equation called Heron's Formula to calculate the area. This is because since I am not given a base, it would be difficult to figure
				//out the output. 
				double heronFormula = (0.5 * (side3 + side4 + side5));
				double heronFormula2 = (heronFormula * (heronFormula-side3) * (heronFormula-side4) * (heronFormula-side5));
				double triArea = (Math.pow(heronFormula2,.5));
				double triPer = (side3 + side4 + side5);
				String triAreaChar = Double.toString(triArea);
				int triAreaCharLength = triAreaChar.length();
				String triPerChar = Double.toString(triPer);
				int triPerCharLength = triPerChar.length();
				
				if ((side3 == side4) && (side4 == side5)) {
					equilateral = true;
					triType = "Equilateral";
				}
				else if (side3 == side4 || side3 == side5 || side4 == side5) {
					isoceles = true;
					triType = "Isosceles";
				}
				else {
					scalene = true;
					triType = "Scalene";
				}
				
				System.out.println("The triangle is: " + triType);
				System.out.println("The perimeter is: " + triPer);
				System.out.println("The area is: " + triArea);
				System.out.println("Total number of digits in the perimeter is: " + (triPerCharLength -1));
				System.out.println("Total number of digits in the area is: " + (triAreaCharLength - 1));
				
				continue;
				
			case "Exit": 
				System.out.println("Terminating the program. Have a nice day! ");
				System.exit(0);
		}
			
		}
	}
}
