/**
 * THE We Solve It Project GOURMET GUARDIAN
 * 
 * @author Walker, Jordan, Christian
 * @version 1.5
 */

import java.util.Scanner;


public class GGDriver {
	//declare necessary fields and objects
	private static Scanner scanner = new Scanner(System.in);
	private static RecipeList recipes = new RecipeList();
	private static IngredientList ingredients = new IngredientList();
	
	public static void main(String[] args) {       
		
		recipes.createFiles();
    	ingredients.createFiles();
    	recipes.load();
    	ingredients.load();
    	
    	mainMenu();
    	
        System.out.println("Bye-bye!");
        ingredients.save();
        recipes.save();
        System.exit(0);
    }
    
	/**
	 * Displays the Main Menu
	 */
    public static void mainMenu() {

        int userInput;
		do {//program loop
        	// print options
        	displayActions();
        	
	        do {//validate selection
	            System.out.print("\nEnter a number between 0 and 3: ");
	            userInput = scanner.nextInt();
	        } while (userInput < 0 || userInput > 3);
	
	        // Process user input
	        System.out.println("You chose: " + userInput);
	        
	        if(userInput == 1) {//Manage Inventory
	        	menuManageYourInventory();	        	
	        }
	        
	        if(userInput == 2) { //Make Recipe
	        	recipes.add(scanner);
	        }	        
	        
	        if(userInput == 3) { //Display Items
	        	menuDisplayItems();
	        }
        }while(userInput != 0);
    }
    
    /**
     * Displays Actions within Main Menu
     */
    public static void displayActions() {    	
        System.out.println("\nChoose an option:");
        System.out.println("0) Quit");
        System.out.println("1) Manage Your Inventory");
        System.out.println("2) Make A Recipe");
        System.out.println("3) Display Items");
    }
    
    /**
     * Provides selection to display recipes or ingredients
     */
    public static void menuDisplayItems() {
    	int userInput;
    	do {
	    	//display options
	    	System.out.println("\nChoose an option:");
	    	System.out.println("0) Go Back");
	    	System.out.println("1) Display Ingredients");
	        System.out.println("2) Display Recipe");
	        
	        
			do {//validate selection
	            System.out.print("\nEnter a number between 0 and 2: ");
	            userInput = scanner.nextInt();
	        } while (userInput < 0 || userInput > 2);
	        // Process user input
	        System.out.println("You chose: " + userInput);
	        
	        if(userInput == 1) {//display inventory
	        	ingredients.display(scanner);	        	
	        }
	        
	        if(userInput == 2) { //display a chosen recipe
	        	recipes.display(scanner);
	        }
    	}while (userInput != 0);
    }
    
    /**
     * Displays options to edit your inventory
     */
    public static void menuManageYourInventory() {
    	int userInput;
    	do {
	    	//display options
	    	System.out.println("\nChoose an option:");
	    	System.out.println("0) Go Back");
	    	System.out.println("1) Add an Ingredient");
	        System.out.println("2) Use an Ingredient");
	        System.out.println("3) Clear Ingredients");
	    	
	        
			do {//validate selection
	            System.out.print("\nEnter a number between 0 and 3: ");
	            userInput = scanner.nextInt();
	        } while (userInput < 0 || userInput > 3);
	        // Process user input
	        System.out.println("You chose: " + userInput);
	        
	        
	        if( userInput == 1 ) {//add ingredient
	        	ingredients.add(scanner);
	        }
	        
	        if( userInput == 2 ) {//use ingredient
	        	ingredients.removeServings(scanner);
	        }
	        
	        if( userInput == 3 ) {//NUKE EM
	        	System.out.print("Are you sure? This will delete ALL your ingredients FOREVER. (forever is a long time!)");
	        	String validate;
				do {//validate selection
		            System.out.print("\nEnter either Y or N: ");
		            validate = scanner.nextLine();
		        	if(validate == "") {//common Walker bug-fix
		        		validate = scanner.nextLine();
		        	}
		        } while (!(validate.toUpperCase()).equals("Y") && !(validate.toUpperCase()).equals("N") );
		        // Process user input
		        System.out.println("You chose: " + validate);
	        	
	        	if(validate.toUpperCase().equals("Y")) {
	        		ingredients.clearAll();
	        		System.out.println("All ingredients have been deleted.");
	        	}
	        	
	        	if(validate.toUpperCase().equals("N")) {
	        		System.out.println("The ingredients live another day.");
	        	}
	        }
	        
    	}while(userInput != 0);
        
        
    }

    //end
}

