import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	@Test
	void TestMorraInfoConstructor() {
		MorraInfo M1 = new MorraInfo(null);
		assertEquals(0, M1.getP1(), "Test1: MorraInfoContructor failed!!");
		assertEquals(0, M1.getP2(), "Test2: MorraInfoContructor failed!!");
		assertEquals(-1, M1.getP1Guess(), "Test3: MorraInfoContructor failed!!");
		assertEquals(-1, M1.getP2Guess(), "Test4: MorraInfoContructor failed!!");
		assertEquals(-1, M1.getP1Points(), "Test5: MorraInfoContructor failed!!");
		assertEquals(-1, M1.getP2Points(), "Test6: MorraInfoContructor failed!!");
	}
	
	@Test
	void TestMorraInfoSetP1Elements() {
		MorraInfo M1 = new MorraInfo(null);
		assertEquals(0, M1.getP1(), "Test1: MorraInfoSetP1Elements failed!!");
		M1.setP1(89);
		assertEquals(89, M1.getP1(), "Test2: MorraInfoSetP1Elements failed!!");
		M1.setP1(-5);
		assertEquals(-5, M1.getP1(), "Test3: MorraInfoSetP1Elements failed!!");
		M1.setP1Play("Two");
		assertEquals("Two", M1.getP1Play(), "Test4: MorraInfoSetP1Elements failed!!");
		M1.setP1Play("Three");
		assertEquals("Three", M1.getP1Play(), "Test5: MorraInfoSetP1Elements failed!!");
	}

	@Test
	void TestMorraInfoSetP2Elements() {
		MorraInfo M1 = new MorraInfo(null);
		assertEquals(0, M1.getP2(), "Test1: MorraInfoSetP2Elements failed!!");
		M1.setP2(48);
		assertEquals(48, M1.getP2(), "Test2: MorraInfoSetP2Elements failed!!");
		M1.setP2(-8);
		assertEquals(-8, M1.getP2(), "Test3: MorraInfoSetP2Elements failed!!");
		M1.setP2Play("Two");
		assertEquals("Two", M1.getP2Play(), "Test4: MorraInfoSetP2Elements failed!!");
		M1.setP2Play("Three");
		assertEquals("Three", M1.getP2Play(), "Test5: MorraInfoSetP2Elements failed!!");
	}
	
	@Test
	void TestMorraInfoGuessElements() {
		MorraInfo M1 = new MorraInfo(null);
		assertEquals(-1, M1.getP1Guess(), "Test1: TestMorraInfoGuessElements failed!!");
		assertEquals(-1, M1.getP2Guess(), "Test2: TestMorraInfoGuessElements failed!!");
		M1.setP1Guess(6);
		assertEquals(6, M1.getP1Guess(), "Test3: TestMorraInfoGuessElements failed!!");
		M1.setP2Guess(-9);
		assertEquals(-9, M1.getP2Guess(), "Test4: TestMorraInfoGuessElements failed!!");
		M1.setP1Guess(9);
		assertEquals(9, M1.getP1Guess(), "Test5: TestMorraInfoGuessElements failed!!");
		
	}
	
	@Test
	void TestMorraInfoBoole() {
		MorraInfo M1 = new MorraInfo(null);
		assertEquals(false, M1.Has2Players, "Test1: MorraInfoBoole failed!!");
		M1.setHas2Players(true);
		assertEquals(true, M1.Has2Players, "Test2: MorraInfoBoole failed!!");
	}
	
}