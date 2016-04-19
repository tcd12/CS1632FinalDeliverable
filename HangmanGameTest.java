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
	public void checkWordEmpty() {
		HangmanGame h = new HangmanGame();
		String word = "";
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
	
	

}
