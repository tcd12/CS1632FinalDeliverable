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

}
