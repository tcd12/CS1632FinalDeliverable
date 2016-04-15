import java.util.Scanner;

public class HangmanDriver {

	public static void main(String[] args) {
		
		HangmanGame h = new HangmanGame();
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to Hangman!");
		System.out.print("Please enter a word to be guessed: ");
		String word = keyboard.next();
		
		while (!h.checkWord(word)) {
			System.out.println("I'm sorry, the entered word is not valid; Please try another word.");
			word = keyboard.next();
		}
		
		int numLetters = h.countLetters(word);

	}

}
