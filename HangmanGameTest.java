import static org.junit.Assert.*;

import org.junit.Test;

public class HangmanGameTest {

	@Test
	//checkWord checks if word valid (all characters)
	public void checkWordValidTest() {
		HangmanGame h = new HangmanGame();
		String word = "desklamp";
		assertTrue(h.checkWord(word));
	}
	
	@Test
	public void checkWordInvalidTest() {
		HangmanGame h = new HangmanGame();
		String word = "12345";
		assertFalse(h.checkWord(word));
	}
	
	@Test
	public void checkWordNullTest() {
		HangmanGame h = new HangmanGame();
		String word = null;
		assertFalse(h.checkWord(word));
	}
	
	@Test
	public void checkWordEmpty() {
		HangmanGame h = new HangmanGame();
		String word = "";
		assertFalse(h.checkWord(word));
	}
	
	@Test
	public void checkWordGreaterThanLetterTest() {
		HangmanGame h = new HangmanGame();
		String word = "{|}";
		assertFalse(h.checkWord(word));
	}
	
	@Test
	public void checkWordBetweenCasesNotLetterTest() {
		HangmanGame h = new HangmanGame();
		String word = "ab[/]ab";
		assertFalse(h.checkWord(word));
	}
	
	@Test
	public void testLetterCountCorrect() {
		HangmanGame h = new HangmanGame();
		String word = "desklamp";	//this word has 8 letters
		int numLetters = h.countLetters(word);
		assertEquals(8, numLetters);
	}
	
	@Test
	public void testLetterCountIncorrect() {
		HangmanGame h = new HangmanGame();
		String word = "desklamp";	//this word has 8 letters
		int numLetters = h.countLetters(word);
		assertFalse(numLetters != 8);
	}
	
	//shows countsLetter() can still handle long words
	@Test
	public void testLetterCountLongWord() {
		HangmanGame h = new HangmanGame();
		StringBuilder longWord = new StringBuilder();
		
		for (int i = 0; i < 100; i++) {
			longWord.append("a");
		}
		
		String word = longWord.toString();
		int numLetters = h.countLetters(word);
		assertEquals(numLetters, word.length());
	}
	
	//shows countsLetter() can handle as long words as memory allows
		@Test
		public void testLetterCountHundredMill() {
			HangmanGame h = new HangmanGame();
			StringBuilder longWord = new StringBuilder();
			
			//100million
			for (int i = 0; i < 100000000; i++) {
				longWord.append("a");
			}
			
			String word = longWord.toString();
			int numLetters = h.countLetters(word);
			assertEquals(numLetters, word.length());
		} 
	
	//tests word length of zero
	@Test
	public void testLetterCountZero() {
		HangmanGame h = new HangmanGame();
		String word = "";	//this word has 8 letters
		int numLetters = h.countLetters(word);
		assertEquals(0, numLetters);
	}
	
	//test if blanks are returned properly
	@Test
	public void testInitializeWordCorrect() {
		HangmanGame h = new HangmanGame();
		int numLetters = 6;
		StringBuilder blanks = new StringBuilder();
		char[] word = h.initializeWord(numLetters);
		for (int i = 0; i < numLetters; i++) {
			System.out.println(word[i]);
			blanks.append(word[i]);
			blanks.append(' ');
		}
		System.out.println(blanks);
		String blank = blanks.toString();
		assertEquals(blank, "_ _ _ _ _ _ ");
	}
	
	//tests word length of zero
	@Test
	public void testInitializeWordWithZero() {
		HangmanGame h = new HangmanGame();
		char[] word = h.initializeWord(0);
		assertEquals(word.length, 0);
	}
	
	//tests max int word length passed in
	@Test
	public void testMaxIntInitialization() {
		HangmanGame h = new HangmanGame();
		char [] word = h.initializeWord(Integer.MAX_VALUE);
		assertEquals(word.length, 0);
	}
	
	//tests negative word length passed in
	@Test
	public void testNegativeIntInitialization() {
		HangmanGame h = new HangmanGame();
		char [] word = h.initializeWord(-10);
		assertEquals(word.length, 0);
	}
	
	//test categorization of word guess
	@Test
	public void testCategorizeGuessWord() {
		HangmanGame h = new HangmanGame();
		String guess = "#hello";
		assertEquals(h.categorizeGuess(guess), "word");
	}
	
	//test categorization of lowercase letter guess
	@Test
	public void testCategorizeGuessLowercaseLetter() {
		HangmanGame h = new HangmanGame();
		String guess = "h";
		assertEquals(h.categorizeGuess(guess), "letter");
	}
	
	//test categorization of uppercase letter guess
		@Test
	public void testCategorizeGuessUppercaseLetter() {
		HangmanGame h = new HangmanGame();
		String guess = "H";
		assertEquals(h.categorizeGuess(guess), "letter");
	}
	
	//test categorization of non-letter
	@Test
	public void testCategorizeGuessError() {
		HangmanGame h = new HangmanGame();
		String guess = "$";
		assertEquals(h.categorizeGuess(guess), "error");
	}
	
	@Test
	public void testCategorizeStringGuess() {
		HangmanGame h = new HangmanGame();
		String guess = "1234536";
		assertEquals(h.categorizeGuess(guess), "error");
	}
	
	//tests null string argument returns error
	@Test
	public void testCategorizeGuessNull() {
		HangmanGame h = new HangmanGame();
		String guess = null;
		assertEquals(h.categorizeGuess(guess), "error");
	}

	@Test
	public void testWordCorrect() {
		HangmanGame h = new HangmanGame();
		String guess = "#hello";
		String word = "hello";
		assertTrue(h.isWordGuessCorrect(guess, word));
	}
	
	@Test
	public void testWordIncorrect() {
		HangmanGame h = new HangmanGame();
		String guess = "yellow";
		String word = "hello";
		assertFalse(h.isWordGuessCorrect(guess, word));
	}
	
	@Test
	public void testWordCorrectWithGuessNull() {
		HangmanGame h = new HangmanGame();
		String guess = null;
		String word = "hello";
		assertFalse(h.isWordGuessCorrect(guess, word));
	}
	
	@Test
	public void testWordCorrectWithWordNull() {
		HangmanGame h = new HangmanGame();
		String guess = "yellow";
		String word = null;
		assertFalse(h.isWordGuessCorrect(guess, word));
	}

	@Test
	public void testWordContainLetter() {
		HangmanGame h = new HangmanGame();
		String guess = "h";
		String word = "hello";
		assertEquals(h.doesWordContainLetter(guess, word), 'h');
	}
	
	@Test
	public void testWordNotContainLetter() {
		HangmanGame h = new HangmanGame();
		String guess = "q";
		String word = "hello";
		assertEquals(h.doesWordContainLetter(guess, word), '0');
	}
	
	@Test
	public void testWordContainLetterGuessNull() {
		HangmanGame h = new HangmanGame();
		String guess = null;
		String word = "hello";
		assertEquals(h.doesWordContainLetter(guess, word), '0');
	}
	
	@Test
	public void testWordContainLetterWordNull() {
		HangmanGame h = new HangmanGame();
		String guess = "h";
		String word = null;
		assertEquals(h.doesWordContainLetter(guess, word), '0');
	}
	
	@Test
	public void testWordContainNotLetter() {
		HangmanGame h = new HangmanGame();
		String guess = "?";
		String word = "hello";
		assertEquals(h.doesWordContainLetter(guess, word), '0');
	}

	@Test
	public void testDrawFigureZero() {
		HangmanGame h = new HangmanGame();
		int numGuesses = 0;
		assertEquals(h.drawFigure(numGuesses), " ____\n |\n |\n_|_\n");
	}
	
	@Test
	public void testDrawFigureOne() {
		HangmanGame h = new HangmanGame();
		int numGuesses = 1;
		assertEquals(h.drawFigure(numGuesses), " ____\n |   O\n |\n_|_\n");
	}
	
	@Test
	public void testDrawFigureTwo() {
		HangmanGame h = new HangmanGame();
		int numGuesses = 2;
		assertEquals(h.drawFigure(numGuesses), " ____\n |   O\n |   |\n_|_\n");
	}
	
	@Test
	public void testDrawFigureThree() {
		HangmanGame h = new HangmanGame();
		int numGuesses = 3;
		assertEquals(h.drawFigure(numGuesses), " ____\n |   O\n |  /|\n_|_\n");
	}
	
	@Test
	public void testDrawFigureFour() {
		HangmanGame h = new HangmanGame();
		int numGuesses = 4;
		assertEquals(h.drawFigure(numGuesses), " ____\n |   O\n |  /|\\\n_|_\n");
	}
	
	@Test
	public void testDrawFigureFive() {
		HangmanGame h = new HangmanGame();
		int numGuesses = 5;
		assertEquals(h.drawFigure(numGuesses), " ____\n |   O\n |  /|\\\n_|_ /\n");
	}
	
	@Test
	public void testDrawFigureSix() {
		HangmanGame h = new HangmanGame();
		int numGuesses = 6;
		assertEquals(h.drawFigure(numGuesses), " ____\n |   O\n |  /|\\\n_|_ / \\\n");
	}

	//testing boundary value of 7 (6 should be max possible guesses)
	@Test
	public void testDrawFigureSeven() {
		HangmanGame h = new HangmanGame();
		int numGuesses = 7;
		assertEquals(h.drawFigure(numGuesses), "error");
	}
	
	@Test
	public void testDrawFigureNegative() {
		HangmanGame h = new HangmanGame();
		int numGuesses = -1;
		assertEquals(h.drawFigure(numGuesses), "error");
	}
	
	@Test
	public void testDrawFigureMaxInt() {
		HangmanGame h = new HangmanGame();
		int numGuesses = Integer.MAX_VALUE;
		assertEquals(h.drawFigure(numGuesses), "error");
	}
	
	@Test
	public void testDrawFigureGreaterThanSixGuesses() {
		HangmanGame h = new HangmanGame();
		int numGuesses = 10;
		assertEquals(h.drawFigure(numGuesses), "error");
	}

	@Test
	public void testUpdateWordArray() {
		HangmanGame h = new HangmanGame();
		char guess = 'h';
		String word = "hello";
		char[] letterArray = {'_', '_', '_', '_', '_'};
		char[] updatedArray = h.updateWordArray(guess, word, letterArray);
		assertEquals(updatedArray[0],'h');
		assertEquals(updatedArray[1], '_');
	}
	
	@Test
	public void testUpdateWordArrayNoMatch() {
	HangmanGame h = new HangmanGame();
	char guess = 't';
	String word = "hello";
	char[] letterArray = {'_', '_', '_', '_', '_'};
	char[] updatedArray = h.updateWordArray(guess, word, letterArray);
	assertEquals(updatedArray[0],'_');
	}
	
	@Test
	public void testUpdateWordArrayNullArray() {
		HangmanGame h = new HangmanGame();
		char guess = 'h';
		String word = "hello";
		char[] letterArray = null;
		char[] updatedArray = h.updateWordArray(guess, word, letterArray);
		assertEquals(updatedArray, null);
	}
	
	@Test
	public void testUpdateWordArrayNull() {
		HangmanGame h = new HangmanGame();
		char guess = '\u0000';
		String word = "hello";
		char[] letterArray = {'_', '_', '_', '_', '_'};
		char[] updatedArray = h.updateWordArray(guess, word, letterArray);
		assertEquals(updatedArray[0],'_');
	}

	@Test
	public void testIfLetterThere() {
		HangmanGame h = new HangmanGame();
		char[] letterArray = {'h', 'e', 'l', 'l', '_'};
		char guess = 'h';
		String word = "hello";
		char[] updatedLetterArray = h.updateWordArray(guess, word, letterArray);
		
		for (int i = 0; i < letterArray.length; i++) {
			System.out.println(letterArray[i] + " (old) vs. " + updatedLetterArray[i]);
		}
		
		assertTrue(h.checkIfAlreadyThere(letterArray, updatedLetterArray));
	}
	
	@Test
	public void testIfLetterNotThere() {
		HangmanGame h = new HangmanGame();
		char[] oldLetterArray = {'h', 'e', 'l', 'l', '_'};
		char guess = 'o';
		String word = "hello";
		char[] updatedLetterArray = h.updateWordArray(guess, word, oldLetterArray);
		
		for (int i = 0; i < oldLetterArray.length; i++) {
			System.out.println(oldLetterArray[i] + " (old) vs. " + updatedLetterArray[i]);
		}	
		assertFalse(h.checkIfAlreadyThere(oldLetterArray, updatedLetterArray));
	}
	
	@Test
	public void testIfLetterThereNullArray() {
		HangmanGame h = new HangmanGame();
		char[] oldLetterArray = null;
		char guess = 'o';
		String word = "hello";
		char[] updatedLetterArray = h.updateWordArray(guess, word, oldLetterArray);
	
		assertFalse(h.checkIfAlreadyThere(oldLetterArray, updatedLetterArray));
	}
	
	@Test
	public void testIfLetterThereArrayNull() {
		HangmanGame h = new HangmanGame();
		char[] oldLetterArray = {'h', 'e', 'l', 'l', '_'};
		char[] updatedLetterArray = null;
	
		assertFalse(h.checkIfAlreadyThere(oldLetterArray, updatedLetterArray));
	}
	
	@Test
	public void testIfLetterThereBothArraysNull() {
		HangmanGame h = new HangmanGame();
		char[] oldLetterArray = null;
		char[] updatedLetterArray = null;
	
		assertFalse(h.checkIfAlreadyThere(oldLetterArray, updatedLetterArray));
	}
	
	@Test
	public void testWinGameTrue(){
		HangmanGame h = new HangmanGame();
		char[] letterArray = {'h', 'e', 'l', 'l', 'o'};
		boolean win = h.winGame(letterArray);
		assertTrue(win);
	}
	
	@Test
	public void testWinGameFalse(){
		HangmanGame h = new HangmanGame();
		char[] letterArray = {'h', '_', 'l', 'l', '_'};
		boolean win = h.winGame(letterArray);
		assertFalse(win);
	}
	
	@Test
	public void testWinGameArrayNull(){
		HangmanGame h = new HangmanGame();
		char[] letterArray = null;
		boolean win = h.winGame(letterArray);
		assertFalse(win);
	}
}
