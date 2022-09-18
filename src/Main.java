import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. Store the coordinates of each character.
		 * 2. read in the sentence
		 * 3. set the original coordinate (0,0)
		 * 3. for each character in the sentence:
		 * 	3.1 get the coordinates of the character. 
		 *  3.2 calculate the distance of the coordinate from the previous coordinates.
		 *  3.3 sum up the distance. 
		 * 4. calculate the distance from 'enter' key to the last coordinates and add to sum.
		 * 5. print out sum.
		 */
		/*
		 * class for primitive types:
		 *   char --> Character
		 *   int  --> Integer
		 *   boolean --> Boolean
		 *   long --> Long
		 *   double --> Double
		 *   float --> Float
		 *   
		 */
		
		// initialize the dictionary for coordinates
		HashMap<Character, int[]> dic = buildDictionary();
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine(); // read in the sentence.
		int[] lastCoordinate = {0,0};
		int[] currentCoordinate;
		int sum = 0;
		for (int i=0;i<sentence.length();i++) { // get all characters
			// i is the index of the character in the sentence
			char c = sentence.charAt(i); // get the character.
			currentCoordinate = dic.get(c); // get current character coordinate
			// calculate the distance from last coordinate to current coordinate
			int distance = Math.abs(currentCoordinate[0] - lastCoordinate[0]) 
					+ Math.abs( currentCoordinate[1]-lastCoordinate[1]);
			
			sum += distance; // sum up the distance.
			lastCoordinate = currentCoordinate; // update last coordinate
		}
		currentCoordinate = dic.get('\n');
		// add the distance to "enter" key
		sum += Math.abs(currentCoordinate[0] - lastCoordinate[0]) 
				+ Math.abs( currentCoordinate[1]-lastCoordinate[1]);
		System.out.println(sum);
		
		
	}

	private static HashMap<Character, int[]> buildDictionary() {
		// TODO Auto-generated method stub
		/* 0. initialize an empty diction.
		 * 1. initialize a 2D array for the keyboard layout.
		 * 2. for each element in the 2D array, do following:
		 * 	2.1 get the position(coordinate) of the element
		 * 	2.2 add to dictionary.
		 * 3. return the dictionary.
		 */
		
		HashMap<Character, int[]> dic = new HashMap<>(); // step 0.
		char[][] layout = {{'A', 'B', 'C','D','E','F'}, {'G','H','I','J','K','L'},
				{'M','N','O','P','Q','R'}, {'S','T','U','V','W','X'}, {'Y','Z',' ', '-', '.', '\n'}}; // step 1
		
		for (int i=0;i<layout.length;i++) { // for each row
			for (int j=0;j<layout[i].length;j++) { //for each column
				// (i,j) is the coordinate.
				// add to dictionary
				dic.put(layout[i][j], new int[]{i,j});
			}
		}
		
		return dic;
	}

}
