import java.util.Scanner;

public class RunGame {
	
	private HangmanGame h = new HangmanGame();
	private String word;
	private boolean winGame = false; 
	
	public void start() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to Hangman!");
		System.out.print("Please enter a word to be guessed: ");
		word = keyboard.next();
		
		while (!h.checkWord(word)) {
			System.out.println("I'm sorry, the entered word is not valid; Please try another word.");
			word = keyboard.next();
		}
		
		int numLetters = h.countLetters(word);
		//prints blanks
		System.out.print("\n\n");
		
		char[] blanks = h.initializeWord(numLetters);
	
		for (int i = 0; i < numLetters; i++) {
			System.out.print(blanks[i] + " ");
		}
		while (!winGame) {
			System.out.println("Enter a letter to guess, or enter '#' followed by the word you'd like to guess: ");
			String guess = keyboard.next();
			
			String guessCategory = h.categorizeGuess(guess);
			if (guessCategory.equals("word")) {
				winGame = h.isWordGuessCorrect(guess, word);
			}
			else if (guessCategory.equals("letter")) {
				//call checkLetterGuess(guess)
			}
			else if (guessCategory.equals("error")) {
				continue;
			}
			
			//print out new figure
		}
		
		keyboard.close();
	}
}
