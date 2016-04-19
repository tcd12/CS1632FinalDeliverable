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
		System.out.print("\n");
		
		//print out current hangman (initial board)
		System.out.println(h.drawFigure(0));
		
		letterArray = h.initializeWord(numLetters);
	
		for (int i = 0; i < numLetters; i++) {
			System.out.print(letterArray[i] + " ");
		}
		while (!winGame) {
			System.out.println("\n\nGuesses remaining: " + (6 - wrongGuesses));
			System.out.print("\nEnter a letter to guess, or enter '#' followed by the word you'd like to guess: ");
			String guess = keyboard.next();
			
			guess = guess.toLowerCase();
			
			String guessCategory = h.categorizeGuess(guess);
			if (guessCategory.equals("word")) {
				winGame = h.isWordGuessCorrect(guess, word);
				if (!winGame) {
					wrongGuesses += 1;
				}
			}
			else if (guessCategory.equals("letter")) {
				//call checkLetterGuess(guess, letterArray)
				 char letter = h.doesWordContainLetter(guess, word);
				if (letter == '0') {
					wrongGuesses += 1;
				}
				else
					letterArray = h.updateWordArray(letter, word, letterArray);
			}
			else if (guessCategory.equals("error")) {
				continue;
			}
			
			//print out potentially-new figure
			System.out.println(h.drawFigure(wrongGuesses));
			
			//print out currently-filled in word
			for (int i = 0; i < letterArray.length; i++) {
				System.out.print(letterArray[i] + " ");
			}
			
			if (h.winGame(letterArray))
				winGame = true;
			
			if (wrongGuesses >= 6) {
				System.out.println("You ran out of guesses! You lose!");
				System.out.println("The word to guess was: " + word);
				break;
			}
		}

		if (winGame){
			System.out.println("Congratulations! You correctly guessed the word!");
			System.out.println("Thanks for playing!");
		}
		
		keyboard.close();
		System.exit(0);
	}
}
