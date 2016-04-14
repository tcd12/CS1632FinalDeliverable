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

}
