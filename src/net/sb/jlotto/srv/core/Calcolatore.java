package net.sb.jlotto.srv.core;

import java.util.logging.Logger;

public class Calcolatore implements ICalcolatore {

    private Logger logger = Logger.getLogger(this.getClass().getName());

	private Integer calcola (char lettera) {
            logger.fine("Richiamato metodo con input " + lettera);
		boolean trovato = false;
		Integer result = Integer.valueOf(0);
		for (int i = 0; i < valori.length; i++) {
			if (valori[i].getLettera().equalsIgnoreCase(String.valueOf(lettera))) {
				result = valori[i].getValore();
				trovato = true;
				break;
			}			
		}
		if (!trovato) {
                    logger.warning(ERR_CARATTERE_NON_VALIDO + " : " + lettera);
                    throw new IllegalArgumentException(ERR_CARATTERE_NON_VALIDO);
                }

                logger.fine("Risultato metodo " + result);
		return result;
	}
	
	public Integer calcola (String lettere) {
            logger.info("Richiamato metodo con input " + lettere);
		Integer result = Integer.valueOf(0);
                char[] caratteri = lettere.toCharArray();
		for (int i = 0; i < caratteri.length; i++) {
			result += calcola(caratteri[i]);
		}

               logger.info("Risultato metodo " + result);
		return result;
	}
}
