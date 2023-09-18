/**
 * Abstract Class that structures how objects are handled in the program
 * @author Christian, Jordan
 * @version 0.3
 */
import java.io.*;
import java.util.*;


public abstract class Item {
	protected FileReader reader;
	protected FileWriter writer;
	protected BufferedReader bReader;
	protected BufferedWriter bWriter;
	/**
	 * Abstract class to be inherited by RecipeList and IngredientList
	 * @param scanner
	 */
	protected void add(Scanner scanner) {
	}
	/**
	 * Abstract class to be inherited by RecipeList and IngredientList
	 */
	protected void save() {
	}
	/**
	 * Abstract class to be inherited by RecipeList and IngredientList
	 * @param scanner
	 */
	protected void display(Scanner scanner) {
	}
	/**
	 * Abstract class to be inherited by RecipeList and IngredientList
	 */
	protected void load() {
	}
	/**
	 * Abstract class to be inherited by RecipeList and IngredientList
	 */
	protected void createFiles(){
	}
}
