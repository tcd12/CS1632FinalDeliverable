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
}
