import java.io.*;
import java.util.*;

/**
 * Inherits from Item class for program functionality and includes an ArrayList to hold recipes
 * @author Christian, Jordan
 * @version 0.4
 */
public class RecipeList extends Item{
	private static ArrayList<String> recipeArray = new ArrayList<>();
	
	/**
	 * Adds Ingredients to the recipeArray
	 * @param Scanner
	 */
	public void add( Scanner scanner) {
    	System.out.println("Please enter a recipe name: ");
    	String recipeName = scanner.nextLine();
    	if(recipeName == "") {//classic Walker bug-fix
    		recipeName = scanner.nextLine();
    	}
    	recipeArray.add(recipeName);
    	String newIngredient = "";
    	while(!(newIngredient.equals("q"))) {
    		System.out.println("Please enter a ingredient (or q if finished): ");
    		newIngredient = scanner.nextLine();
    		if(newIngredient.equals("q")) {
    			break;
    		}
    		recipeArray.add(newIngredient);
    		System.out.println("Please enter the amount of the ingredient: ");
    		String servings = scanner.nextLine();
    		if(servings == "") {
    			servings = scanner.nextLine();
    		}
    		recipeArray.add(servings);
    	}
    	recipeArray.add("+");
        save();
    }
	/**
	 * Saves recipeArray to file
	 */
	public void save() {
	   	 try { //recipe writing
	   		 writer = new FileWriter("RecipeFile.txt"); 
	   		 bWriter = new BufferedWriter(writer);
	   		 
	   		 for (String stringValue : recipeArray) {
	                bWriter.write(stringValue + "\n");
	   		 }
	   		 
	   		 bWriter.close();
	         writer.close();
	   	 }catch(IOException eie) {
	   		 System.out.println("You did something wrong.");
	   	 }
  	}
	/**
	 * Displays recipeArray
	 * @param Scanner
	 */
	public void display( Scanner scanner) {
    	System.out.println("Please enter the recipe you want to see: ");
    	String recipe = scanner.nextLine();
    	while(recipe == "") {
    		recipe = scanner.nextLine();
    	}
    	int pos = recipeArray.indexOf(recipe);
    	if(pos == -1) {
    		System.out.println("This item does not exist yet.");
    	}else {
    		int saveUs = 0;//loop count variable
    		do { 
    			if(saveUs == 0) {    				
    				saveUs++;
    				System.out.println("Recipe: ");
    				System.out.println(recipeArray.get(pos));
    				pos++;
    				System.out.println("\nItem:\tCount: ");
    			}
    			System.out.println(recipeArray.get(pos) + "\t" + recipeArray.get(pos + 1));
    			
    			pos = pos + 2;
    			
    		}while(!((recipeArray.get(pos)).equals("+")));
    		
    		}
    		
    }
	/**
	 * Stuffs the recipeArray with info from the files
	 */
	public void load() {
	   	 try {
	   		 recipeArray.clear();
	   		 reader = new FileReader("RecipeFile.txt"); 
	   		 bReader = new BufferedReader(reader);
	   		 
	   		 String lineR;
	   		 while ((lineR = bReader.readLine()) != null) {
	   			 recipeArray.add(lineR);
	   		 }
	   		 
	   		 reader.close();
	       	 bReader.close();
	   	 }catch(IOException eiei) {
	   		 System.out.println("You did something wrong.");
	   	 }
  	}
	/**
	 * Creates the file
	 */
	public void createFiles(){ 
    	try {
    		reader = new FileReader("RecipeFile.txt"); 
            bReader = new BufferedReader(reader);

            if ((bReader.readLine()) != null) {
            	System.out.println("Welcome back! What would you like to do?");
            }
            
            reader.close();
        	bReader.close();
        	
    	}catch( IOException e ) { //If the reader errors, there must be no file.
        	try { //By writing to the non-existent file, it in turn creates it.
                writer = new FileWriter("RecipeFile.txt");
                bWriter = new BufferedWriter(writer);
                
                System.out.println("Welcome to Gourmet Guardian!\nWith this helpful program, you can add ingredients to your inventory, create recipes, and more!");
                System.out.println("What would you like to do first?");
                
                writer.close(); 
            	bWriter.close();
        	}catch( IOException ef) {
        		System.out.println("Oh." + ef); //I'm not sure what would cause this
        	}
    	}
    }
//end	
}
