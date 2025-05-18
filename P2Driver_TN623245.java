/** 	
 * ICSI/IECE 201 Introduction to Computer Science
 * Semester Fall 2024
 * Lab class Every Thursday 4.30pm - 5.25pm
 * Trinh Nguyen
 * TN623245
 * Tnguyen31@albany.edu
 * This program creates a menu option for the player to choose from. 
 * Each option will display a different program to show/sort the certain list of hero characters.  
 */
import java.util.Scanner;
import java.io.*;

public class P2Driver_TN623245 {
	private static int count = 0; 	//static field to store number of existing lines in the text file
	
	public static void main(String[]args) throws IOException {
		
		//Initialize text file reading
		File file = new File("text file.txt");
		Scanner myfile = new Scanner (file);
		final int MAX_SIZE =100; //Maximum size of the lines restricted
		Hero_TN623245[] heroes = new Hero_TN623245[MAX_SIZE];	//Declare an array of fixed Hero_TN623245 objects
			
		//Read data from text file and initialize hero's object
	    while(myfile.hasNextLine() && count < MAX_SIZE) {
	    	 String line = myfile.nextLine();			//Read each line from text file
	    	 heroes[count] = new Hero_TN623245(line);	//Create new hero object from line data
	    	 heroes[count].updateHealth();				//Update hero's health with randomization
	    	 count++; 
	    }
	    myfile.close();    //Close file scanner	
	    
	    //Display menu option
	    menu(heroes);
	}
	
	//Method 1: Show the list on the screen sorted alphabetically by the names
	public static void showSortedName(Hero_TN623245[] heroes) {
		//Bubble sort by name; outer loop iterate through each element in the array
		for (int i = 0; i < count-1; i++) {
			
			//Inner loop to compare and swap name element by order
			for (int j = 0; j < count -i -1; j++) {
				//Compare name of current hero with next hero in the array
				if (heroes[j].getName().compareTo(heroes[j+1].getName()) >0) {
					
					//Swap heroes[j] with heroes[j+1] if they are not in alphabetical order
					Hero_TN623245 temp = heroes[j];	//temp variable to hold current name
					heroes[j] = heroes[j+1];		//Assign next name to the current position
					heroes[j+1] = temp;				//Assign the temp hero to the next position
				}
			}
		}
		
		//Display sorted name
		System.out.println();
		for (int i = 0; i < count; i++) {
			System.out.println("Hero "+ (i+1) + heroes[i]);}
		System.out.println();
	}	
	
	//Method 2: Find and show all characters with a specified attack ability.
	public static void showAttackAbility(Hero_TN623245[] heroes) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your desired ability: ");
		String skill = input.nextLine().toLowerCase();
		System.out.println("Loading...The heroes that possess skill "+ "'"+ skill +"'" +" are:");
		
		//Search for heroes with matching attack ability
		boolean notFound = true;	//Flag to check if hero with specific skill is found
		
		//Loop  through each element in the array to find matches with skill
		for (int i = 0; i < count;i++) {
			
			//Convert detail skill into lowercase and check if the skill is present
			if (heroes[i].toString().toLowerCase().contains(skill)) {
				
				//if match, display the hero's info with given syntax
				System.out.println("Hero " +(i+1) + ": Name = " + heroes[i].getName() +
						", "+"AttackAbility =" + heroes[i].getAttackAbility());
				
				//Set flag to false if the match is found
				notFound = false;
			}
		}
		System.out.println(); // Additional newline for readability
		//If no hero was found with the skill, print the message
		if (notFound) {
			System.out.println("The hero is not found!");
		}
		System.out.println();
	}
		
	//Method 3: Show the list on the screen sorted from the lowest to the highest character's power.
	public static void showSortedPower(Hero_TN623245[] heroes) {
		//Bubble sort by power; outer loop iterate through each element in the array
		for (int i = 0; i < count-1; i++) {
			
			//Inner loop to compare and swap power element by order
			for (int j =  0; j < count- i -1; j++) {
				
				//Check if the current hero's power is greater than the next's
				if (heroes[j].getPower() > heroes[j+1].getPower()) {
					
					//Swap heroes[j] with heroes[j+1] if they are not in order
					Hero_TN623245 temp1 = heroes[j];	//temp variable to hold current hero's power
					heroes[j] = heroes[j+1];			//Move next hero's to current position
					heroes[j+1] = temp1;				//Assign the temp hero's value to the next position
				}
			}
		}
		
		//Display sorted hero by power
		System.out.println("Here is the full list of characters whose power score sorted from lowest to highest: ");
		System.out.println();
		
		//Loop through each hero and print their info
		for (int i = 0; i < count; i++) {
			System.out.println("Hero "+ (i+1) + heroes[i]);
		}
		System.out.println();	//additional line for readability
	}
		
	//Method 4: Calculate the total power of all characters.
	public static double sumTotalPower(Hero_TN623245[] heroes) {
		double sum = 0;	//Initialize variable to store sum of powers
		
		//Loop through each hero in the array
		for (int i = 0; i < count; i++) {
			//Add the power of each hero to sum
			sum += heroes[i].getPower();
		}
		//Display the total score
		System.out.println("Total power from all heroes combined is: " + sum);
		System.out.println();
		return sum;	//Return the total sum of power
	}
		
	//Creating Menu to choose options
	public static void menu(Hero_TN623245[] heroes) {
		boolean check = true;	//flag to control menu loop; it will be set to false if player choose to quit
		Scanner option = new Scanner (System.in);	//Initialize Scanner to read player's input
		
		//Loop to display the menu option repeatedly
		while (check) {
			//Display menu option
			System.out.println("Please choose the option you want to display by typing 1,2,3,4,5: ");
			System.out.println("*************************************************************************");
			System.out.println(	"1. Show all characters ordered"+"\n"+
								"2. Find characters with attack ability" +"\n"+
								"3. Sort characters by power" +"\n"+
								"4. Calculate the total power" +"\n"+
								"5. Quit");
			System.out.println("*************************************************************************");
						
			int choice = option.nextInt();	//Read player choice as integer
			option.nextLine();	//Consume new line
			
			//Process player choice
			switch (choice) {
				case 1:
					System.out.println("Ok! You choose option 1: Show all characters ordered.");
					showSortedName(heroes);	//Call the method to display uder name sorted
					break;
				case 2:
					System.out.println("Ok! You choose option 2: Find characters with attack ability.");
					showAttackAbility(heroes);	//Call the method to show heroes by searching for ability
					break;
				case 3: 
					System.out.println("Ok! You choose option 3: Sort characters by power.");
					showSortedPower(heroes);	//Call the method to display hero's powered scores sorted
					break;
				case 4:
					System.out.println("Ok! You choose option 4: Calculate the total power.");
					sumTotalPower(heroes);	//Call the method to calculate total power score
					break;
				case 5:
					System.out.println("Ok! You choose option 5: Quit.");
					System.out.println("Thank you, have a good day!");
					check = false;	//Set flag to false and exit the loop
					break;
				//Display message when player enter invalid input
				default: 
						System.out.println("Invalid input, please type 1 option again 1,2,3,4 or 5.");
						break;
			}
		}
		option.close(); //Close the Scanner for user input
	}
}
		
	    		
	    
	   	

		
	    
		 
		 
