import java.io.*;
import java.util.*;
/**
 * Inherits from Item class for program functionality and includes an ArrayList to hold ingredients
 * @author Christian, Jordan
 * @version 0.4
 */
public class IngredientList extends Item{
	private ArrayList<Integer> servings = new ArrayList<>();
	private ArrayList<String> names = new ArrayList<>();
	private ArrayList<Double> price = new ArrayList<>();
	/**
	 * Adds ingredient information to their respective array
	 * Also if ingredient already exists it asks if you would like to add more
	 * @param Scanner
	 */
	public void add(Scanner scanner) {//creates new ingredient or adds servings to existing ingredient
    	System.out.println("Please enter the name of your ingredient: "); //naem
    	String ingredientName = scanner.nextLine();
    	if(ingredientName == "") { //simple bugfix
    		ingredientName = scanner.nextLine();
    	}
    	int pos = names.indexOf(ingredientName);
    	if(pos == -1) {
    		names.add(ingredientName);
        	System.out.println("Please enter the price: "); //price yk
        	price.add(scanner.nextDouble());
        	System.out.println("How many servings are in "+ ingredientName +": ");
        	servings.add(scanner.nextInt());
    	}else {
    		System.out.println("Names:\tCount:\tPrice:\t");
    		System.out.println(names.get(pos)+"\t"+servings.get(pos)+"\t"+price.get(pos));
    		System.out.println("How many items would you like to add: ");
    		int tNums = scanner.nextInt();
    		int sum = tNums + servings.get(pos);
    		servings.set(pos, sum );
    		System.out.println("You now have "+ sum +" servings of "+ ingredientName +".");
    		
    	}
        save();
    }
	/**
	 * Saves the ingredients to the file
	 */
	public void save() {
    	try { //ingredients writing
    		 writer = new FileWriter("GGFile.txt"); 
    		 bWriter = new BufferedWriter(writer);
             for (Integer intValue : servings) {
                 bWriter.write(intValue.toString() + "\n");
             }
             for (String stringValue : names) {
                 bWriter.write(stringValue + "\n");
             }
             for (Double doubleValue : price) {
                 bWriter.write(doubleValue.toString() + "\n");
             }
             bWriter.close();
             writer.close();
    	 }catch(IOException ei) {
    		 System.out.println("This should never happen, file wasn't found???");
    	 }
    }
	/**
	 * Displays the Ingredients
	 */
	public void display(Scanner scanner){        
	   	 System.out.println("Names:\tCount:\tPrice:\t");
	   	 for(int i = 0; i < names.size(); i = i + 1) {
	   		 System.out.println(names.get(i)+"\t"+servings.get(i)+"\t"+price.get(i));
	   	 }
	}
	/**
	 * Loads everything into the ArrayLists with their respective data types
	 */
	public void load() {
	   	 try {
	   		 servings.clear();
	   		 names.clear();
	   		 price.clear();
	   		 reader = new FileReader("GGFile.txt"); 
	   		 bReader = new BufferedReader(reader);
	   		 
	   		 String line;
	   		 while ((line = bReader.readLine()) != null) {
	   			 try {
	   				 int intValue = Integer.parseInt(line);                   
	   				 servings.add(intValue);                                  
	   			 } catch (NumberFormatException e) {
	           	 try {
	           		  double doubleValue = Double.parseDouble(line);
	                     price.add(doubleValue);
	             } catch (NumberFormatException e2) {
	               	 names.add(line);
	                	}
	   			 }
	   		 }
	   		 reader.close();
	       	 bReader.close();
	   	 }catch(IOException eo) {
	   		 System.out.println("This shouldn't happen either");
	   	 		}
  	}
	/**
	 * Removes servings that you have used
	 * @param scanner
	 */
	public void removeServings(Scanner scanner) { 
    	System.out.println("Please enter the ingredient you wish to use: ");
    	String ingredient = scanner.nextLine();
    	while(ingredient == "") {
    		ingredient = scanner.nextLine();
    	}
    	int pos = names.indexOf(ingredient);
    	if(pos == -1) {
    		System.out.println("This item does not exist yet.");
    	}else {
    		System.out.println("Names:\tCount:\tPrice:\t");
    		System.out.println(names.get(pos)+"\t"+servings.get(pos)+"\t"+price.get(pos));
    		System.out.println("How many servings of this ingredient have you used?  ");
    		int userNum = scanner.nextInt();
    		int difference = servings.get(pos) - userNum;
    		if(difference < 0) {
    			servings.set(pos, 0);
    			System.out.print("\nYou've run out of "+ ingredient +"!");
    		}
    		else {
    			servings.set(pos, difference);
    			System.out.print("You now have "+ difference +" servings of "+ ingredient +".");
    		}
    		
    	}
        save();
    }
	/**
	 * Clears all ArrayLists and writes them into the file (clears the file)
	 */
	public void clearAll() {
    	servings.clear();
  		names.clear();
  		price.clear();
  		save();
    }
	/**
	 * creates the Ingredient file
	 */
	public void createFiles(){ 
    	try {
    		reader = new FileReader("GGFile.txt"); 
            bReader = new BufferedReader(reader);

            while ((bReader.readLine()) != null) {
            	
            }
            
            reader.close();
        	bReader.close();
        	
    	}catch( IOException e ) { //If the reader errors, there must be no file.
        	try { //By writing to the non-existent file, it in turn creates it.
                writer = new FileWriter("GGFile.txt");
                bWriter = new BufferedWriter(writer);
                
                writer.close(); 
            	bWriter.close();
        	}catch( IOException ef) {
        		System.out.println("Oh." + ef); //I'm not sure what would cause this
        	}
    	}
	}
}
