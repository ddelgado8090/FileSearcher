//Honor Code: I have neither given nor received unauthorized aid on this assignment.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileSearcher {

	public static BinarySearchTree<Word> BST = new BinarySearchTree<Word>();
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String directoryArg = args[0];
		File fileName = new File(directoryArg);
		readFile(fileName);
		
		Scanner scan = new Scanner (System.in);

		boolean plays = true; 
		while (plays) {
			System.out.println("Please enter a command (a, s, or q)");
			String userChoice = scan.nextLine();
			
			if (userChoice.equals("a")) {
				userChoiceA(); //calls userChoiceA method 
			}
			else if (userChoice.equals("s")) {
				userChoiceS(); //calls userChoiceS method
			}
			else if (userChoice.equals("q")) {
				plays = false; //quits game
			}
		}//while loop
		
		
		
		scan.close();
	} //main method
	
	public static void readFile(File folder) throws IOException { //reads file
		
		File[] list = folder.listFiles();
		for (File file : list) {
			if(!file.isHidden()&& file.getName().charAt(0)!= '.') { //ignores hidden files
				if (file.isDirectory()) {
					readFile(file);
				}
				
				else {
					Scanner fr = new Scanner (file);
					
					while (fr.hasNextLine()) {
						String line = fr.nextLine();
						String[] words = line.split(" "); //splits row across by names separated by a space
						
						for (String w : words) {
							String string = "";
							
							for (int i=0; i<w.length(); i++) { 
								if (Character.isLetter(w.charAt(i)) || Character.isDigit(w.charAt(i))) { //checks if a character at an index in w is a letter or a digit
									string = string + (w.charAt(i)); //adds the character to the string if it is a letter or digit
								}//if statement
							}//nested for 
							
							Word objW = new Word(string); 
							
							if (!BST.contains(objW)) {
								objW.add(file.getName()); //updates file list of word
								BST.insert(objW); 

							}
							else if (BST.contains(objW)) {
								Word objBST = BST.find(objW);
								objBST.add(file.getName());
							}
						}//second for loop
					}//while loop
				}//else
			}//second if
		}//first for loop

	}
	
	
	
	public static void userChoiceA() {
		
		BST.printTree(); //calls printTree method from BinarySearchTree class
	}
	
	
	public static void userChoiceS() {
		
		Scanner scan = new Scanner (System.in);

		System.out.println("Word to find>>");
		String userWord = scan.nextLine();
		Word chosenWord = new Word (userWord); //makes userWord into an object
		
		if (BST.contains(chosenWord)) {
			System.out.println(BST.find(chosenWord).toString()); //finds if the chosenWord object is in a node in the BST, as it exists in the BST
		}
		else {
			System.out.println(userWord + " is not found");
		}
	}//main
}

	
	