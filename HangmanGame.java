import java.util.Arrays;

public class HangmanGame {
	
	public HangmanGame() {
	}
	
	//checks if word valid (all letters)
	//calls setWord() if valid
	//returns if valid word or not
	public Boolean checkWord(String word) {
		
		if ((word == null) || (word.equals("")))
				return false;
		
		char[] wordArray = word.toCharArray();
		for (char c : wordArray) {
			//if c is not between 65 and 90 and not between 97 and 122 (not uppercase or lowercase letter)
			//return false, not a valid word
			if (!((c >= 65) && (c <= 90)) && !((c >= 97) && (c <= 122))) {
				return false;
			}
		}
		return true;
	}
	
	//counts number of letters in word once validated
	//returns number of letters in word
	public int countLetters(String word) {
		int numLetters = word.length();
		return numLetters;
	}
	
	//creates array of letters to print, initializes to blanks
	public char[] initializeWord(int numLetters) {
		if ((numLetters == Integer.MAX_VALUE) || (numLetters < 0)) {
			System.out.println("Error: invalid word length");
			return new char[0];
		}
		char[] word = new char[numLetters];
		for (int i = 0; i < numLetters; i++) {
			word[i] = '_';
		}
		return word;
	}
	
	//categorizes guess as word or letter
	public String categorizeGuess(String guess) {
		//if guess is null, return error
		if (guess == null) {
			System.out.println("Error: invalid guess");
			return "error";
		}
		
		//if first char = '#', return "word"
		String firstChar = guess.substring(0, 1);
		if (firstChar.equals("#"))
			return "word";
		
		//else if first char != '#', check if letter
		else {
			
			if (guess.length() > 1) {
				System.out.println("\nSorry, please enter a word guess after the '#' symbol, or guess a single letter!");
				return "error";
			}
			
			char c = firstChar.charAt(0);
			//if not letter, return "error"
			if (!((c >= 65) && (c <= 90)) && !((c >= 97) && (c <= 122))) {
				System.out.println("Error: invalid guess");
				return "error";
			}
			//else, return "letter"
			else
				return "letter";
		}
	}
	
	//returns if word guess is correct or not
	public boolean isWordGuessCorrect(String guess, String word) {
		if ((guess == null) || (word == null)) {
			System.out.println("An error has occurred.");
			return false;
		}
		
		guess = guess.substring(1);
		
		if (guess.equals(word)) {
			System.out.println("\nYou guessed it!");
			return true;
		}
		else {
			System.out.println("Sorry, your guess doesn't match the word!");
			return false;
		}
	}
	
	public char doesWordContainLetter(String guess, String word) {
		if ((guess == null) || (word == null)) {
			System.out.println("An error has occurred.");
			return '0';
		}
		
		char letter = Character.toLowerCase(guess.charAt(0));
		
		for (int i = 0; i < word.length(); i++) {
			if (letter == word.charAt(i)) {
				return letter;
			}
		}
		
		return '0';
	}
	
	
	public char[] updateWordArray(char guess, String word, char[] letterArray) {
		if ((guess == '\u0000') || (letterArray == null)) {
			System.out.println("An error has occurred.");
			return letterArray;
		}
		
		char[] newLetterArray = new char[letterArray.length];
		newLetterArray = Arrays.copyOf(letterArray, letterArray.length);
		
		for (int i = 0; i < letterArray.length; i++) {
			if (word.charAt(i) == guess) {
				newLetterArray[i] = guess;
			}
		}
		return newLetterArray;
	}
	
	//compares array before update to after, check if change
	public boolean checkIfAlreadyThere(char[] oldLetterArray, char[] updatedLetterArray) {
		if ((oldLetterArray == null) || (updatedLetterArray == null)) {
			System.out.println("An error has occurred.");
			return false;
		}
		return Arrays.equals(oldLetterArray, updatedLetterArray);
	} 
	
	public boolean winGame(char[] letterArray) {
		if (letterArray == null) {
			return false;
		}
		
		int blanks = 0;
		for (int i = 0; i < letterArray.length; i++) {
			if (letterArray[i] == '_') {
				blanks++;
			}
		}
		if (blanks == 0) {
			return true;
		}
		else
			return false;
	}
	
	public String drawFigure(int wrongGuesses) {

		if (wrongGuesses > 6) {
			System.out.println("Max number of possible guesses has been exceeded! You lose!");
			return "error";
		}
		else {
			switch (wrongGuesses) {
				case 0:
					return " ____\n |\n |\n_|_\n";
				case 1:
					return " ____\n |   O\n |\n_|_\n"; 
				case 2:
					return " ____\n |   O\n |   |\n_|_\n";	
				case 3:
					return " ____\n |   O\n |  /|\n_|_\n";
				case 4:
					return " ____\n |   O\n |  /|\\\n_|_\n";
				case 5:
					return " ____\n |   O\n |  /|\\\n_|_ /\n";
				case 6:
					return " ____\n |   O\n |  /|\\\n_|_ / \\\n";
				default:
					System.out.println("An error has occurred.");
					return "error";
			}
		}
	}
	

}
