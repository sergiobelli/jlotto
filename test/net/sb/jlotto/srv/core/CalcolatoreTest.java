package net.sb.jlotto.srv.core;

import junit.framework.TestCase;

public class CalcolatoreTest extends TestCase {

	private Calcolatore calcolatore;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		calcolatore = new Calcolatore();
	}

	public void testCalcolaString() {		
		assertEquals(Integer.valueOf(1), calcolatore.calcola("A"));
		assertEquals(Integer.valueOf(2), calcolatore.calcola("B"));
		assertEquals(Integer.valueOf(3), calcolatore.calcola("C"));
		assertEquals(Integer.valueOf(4), calcolatore.calcola("D"));
		assertEquals(Integer.valueOf(5), calcolatore.calcola("E"));	
		assertEquals(Integer.valueOf(6), calcolatore.calcola("F"));
		assertEquals(Integer.valueOf(7), calcolatore.calcola("G"));
		assertEquals(Integer.valueOf(8), calcolatore.calcola("H"));
		assertEquals(Integer.valueOf(9), calcolatore.calcola("I"));
		assertEquals(Integer.valueOf(10), calcolatore.calcola("J"));
		assertEquals(Integer.valueOf(20), calcolatore.calcola("K"));
		assertEquals(Integer.valueOf(30), calcolatore.calcola("L"));
		assertEquals(Integer.valueOf(40), calcolatore.calcola("M"));
		assertEquals(Integer.valueOf(50), calcolatore.calcola("N"));
		assertEquals(Integer.valueOf(60), calcolatore.calcola("O"));
		assertEquals(Integer.valueOf(70), calcolatore.calcola("P"));
		assertEquals(Integer.valueOf(80), calcolatore.calcola("Q"));
		assertEquals(Integer.valueOf(90), calcolatore.calcola("R"));
		assertEquals(Integer.valueOf(100), calcolatore.calcola("S"));
		assertEquals(Integer.valueOf(200), calcolatore.calcola("T"));
		assertEquals(Integer.valueOf(300), calcolatore.calcola("U"));
		assertEquals(Integer.valueOf(400), calcolatore.calcola("V"));
		assertEquals(Integer.valueOf(500), calcolatore.calcola("W"));	
		assertEquals(Integer.valueOf(600), calcolatore.calcola("X"));
		assertEquals(Integer.valueOf(700), calcolatore.calcola("Y"));	
		assertEquals(Integer.valueOf(800), calcolatore.calcola("Z"));
		assertEquals(Integer.valueOf(99), calcolatore.calcola("?"));
		assertEquals(Integer.valueOf(11), calcolatore.calcola("!"));
		
		
	}

	public void testCalcolaStringArray() {
//		ESEMPIO:S	E	R	G	I	O
//				100	5	90	7	9	60	=	SOMMA  	271
//
//				B	E	L	L	I
//				2	5	30	30	9		=	SOMMA	76	
		
		String nome = "Sergio";
		assertTrue(Integer.valueOf(271).equals(calcolatore.calcola(nome)));
		
		String cognome = "Belli";
		assertTrue(Integer.valueOf(76).equals(calcolatore.calcola(cognome)));
		
	}

	public void testCalcolaIllegal() {
		try {
			calcolatore.calcola(":");
			fail("Expected exception " + ICalcolatore.ERR_CARATTERE_NON_VALIDO);
		} catch (Exception ex) {
			assertEquals(ICalcolatore.ERR_CARATTERE_NON_VALIDO, ex.getMessage());
		}
	}
}
