import java.util.Scanner;

public class RunGame {
	
	public HangmanGame h = new HangmanGame();
	
	public RunGame() {
		
	}
	
	public void start() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to Hangman!");
		System.out.print("Please enter a word to be guessed: ");
		String word = keyboard.next();
		
		while (!h.checkWord(word)) {
			System.out.println("I'm sorry, the entered word is not valid; Please try another word.");
			word = keyboard.next();
		}
		
		int numLetters = h.countLetters(word);
		//prints blanks
		System.out.print("\n\n" + h.printBlanks(numLetters));
		System.out.println("Enter a letter to guess, or enter '#' followed by the word you'd like to guess: ");
		String guess = keyboard.next();
		
		
		keyboard.close();
	}
}
