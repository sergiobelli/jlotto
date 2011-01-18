package net.sb.jlotto.srv.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import net.sb.jlotto.srv.core.model.Citta;
import net.sb.jlotto.srv.core.model.Estrazione;
import net.sb.jlotto.srv.core.model.Ruota;

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


        public void testFiltra() {
            Ruota ruota = new Ruota(new Citta("MI", "Milano"), 1,2,3,4,5,6,7,8,9,10);
            Estrazione estr = new Estrazione(new Date(), ruota);

            assertEquals(0, calcolatore.filtra(estr, 12).size());
            assertEquals(1, calcolatore.filtra(estr, 10).size());

            estr.addRuota(new Ruota(new Citta("TO", "Torino"), 10,12,13,14,15,16,17,18,19,20));
            assertEquals(2, calcolatore.filtra(estr, 10).size());
        }


    public void testEstrai() {
        try {
            Calcolatore c = new Calcolatore();
            Estrazione e = c.estrai("milano 1 2 3 4 5 6 " + "torino 9 8 7 6 5 4 " + "genova 12 23 45 65 78 88");
            System.out.println(e);

            assertTrue("milano".equalsIgnoreCase(e.getRuota("milano").getCitta().getNome()));
            assertTrue(6 == e.getRuota("milano").getNumeri().size());
            assertTrue(1 == e.getRuota("milano").getNumeri().get(0));
            assertTrue(2 == e.getRuota("milano").getNumeri().get(1));
            assertTrue(3 == e.getRuota("milano").getNumeri().get(2));
            assertTrue(4 == e.getRuota("milano").getNumeri().get(3));
            assertTrue(5 == e.getRuota("milano").getNumeri().get(4));
            assertTrue(6 == e.getRuota("milano").getNumeri().get(5));

            assertTrue("torino".equalsIgnoreCase(e.getRuota("torino").getCitta().getNome()));
            assertTrue(6 == e.getRuota("torino").getNumeri().size());
            assertTrue(9 == e.getRuota("torino").getNumeri().get(0));
            assertTrue(8 == e.getRuota("torino").getNumeri().get(1));
            assertTrue(7 == e.getRuota("torino").getNumeri().get(2));
            assertTrue(6 == e.getRuota("torino").getNumeri().get(3));
            assertTrue(5 == e.getRuota("torino").getNumeri().get(4));
            assertTrue(4 == e.getRuota("torino").getNumeri().get(5));


            assertTrue("genova".equalsIgnoreCase(e.getRuota("genova").getCitta().getNome()));
            assertTrue(6 == e.getRuota("genova").getNumeri().size());
            assertTrue(12 == e.getRuota("genova").getNumeri().get(0));
            assertTrue(23 == e.getRuota("genova").getNumeri().get(1));
            assertTrue(45 == e.getRuota("genova").getNumeri().get(2));
            assertTrue(65 == e.getRuota("genova").getNumeri().get(3));
            assertTrue(78 == e.getRuota("genova").getNumeri().get(4));
            assertTrue(88 == e.getRuota("genova").getNumeri().get(5));

            assertEquals("12/10/2010", new SimpleDateFormat("dd/MM/yyyy").format(e.getData()));
            
        } catch (Exception ex) {
            Logger.getLogger(CalcolatoreTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }



    public void testEstrai2() {
        try {
            Calcolatore c = new Calcolatore();
            Estrazione e = c.estrai(
                    "Bari  	24  	40  	57  	77  	29"+
                    "Cagliari 	27 	81 	9 	51 	8"+
                    "Firenze 	61 	51 	87 	44 	10"+
                    "Genova 	72 	79 	25 	7 	15"+
                    "Milano 	47 	37 	85 	44 	16"+
                    "Napoli 	44 	65 	2 	23 	78"+
                    "Palermo 	30 	11 	56 	31 	10"+
                    "Roma 	60 	12 	78 	86 	5"+
                    "Torino 	70 	90 	30 	12 	54"+
                    "Venezia 	31 	62 	54 	89 	82"+
                    "Nazionale 	15 	16 	49 	11 	17");
            System.out.println(e);
        } catch (Exception ex) {
            Logger.getLogger(CalcolatoreTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }
}




