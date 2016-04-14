public class HangmanGame {
	
	private String word = "";
	private int numLetters = 0;
	
	public HangmanGame() {
		
	}
	
	//checks if word valid (all letters)
	//calls setWord() if valid
	//returns if valid word or not
	public Boolean checkWord(String word) {
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

}