import java.util.Scanner;

public class RunGame {
	
	private HangmanGame h = new HangmanGame();
	private String word;
	private boolean winGame = false; 
	private char[] letterArray;
	private int wrongGuesses = 0;
	
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
		
		char[] letterArray = h.initializeWord(numLetters);
	
		for (int i = 0; i < numLetters; i++) {
			System.out.print(letterArray[i] + " ");
		}
		while (!winGame) {
			System.out.println("Enter a letter to guess, or enter '#' followed by the word you'd like to guess: ");
			String guess = keyboard.next();
			
			String guessCategory = h.categorizeGuess(guess);
			if (guessCategory.equals("word")) {
				winGame = h.isWordGuessCorrect(guess, word);
				if (!winGame) {
					wrongGuesses += 1;
				}
			}
			else if (guessCategory.equals("letter")) {
				//call checkLetterGuess(guess, letterArray)
				boolean rightLetter = h.doesWordContainLetter(guess, word);
				if (!rightLetter) {
					wrongGuesses += 1;
				}
			}
			else if (guessCategory.equals("error")) {
				continue;
			}
			
			//print out new figure
			h.drawFigure(wrongGuesses);
		}
		
		keyboard.close();
	}
}
