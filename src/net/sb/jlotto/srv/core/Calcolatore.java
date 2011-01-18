package net.sb.jlotto.srv.core;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import net.sb.jlotto.shr.Eval;
import net.sb.jlotto.srv.core.model.Citta;
import net.sb.jlotto.srv.core.model.Estrazione;
import net.sb.jlotto.srv.core.model.Ruota;

public class Calcolatore implements ICalcolatore {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Integer calcola(char lettera) {
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

    public Integer calcola(String lettere) {
        logger.info("Richiamato metodo con input " + lettere);
        Integer result = Integer.valueOf(0);
        char[] caratteri = lettere.toCharArray();
        for (int i = 0; i < caratteri.length; i++) {
            result += calcola(caratteri[i]);
        }

        logger.info("Risultato metodo " + result);
        return result;
    }

    public List<Ruota> filtra(Estrazione estrazione, Integer numero) {
        List<Ruota> result = new ArrayList<Ruota>();
        if (Eval.areNotNulls(estrazione,numero)) {
            for (Ruota ruota : estrazione.getRuote()) {
                if (ruota.getNumeri().contains(numero)) {
                    result.add(ruota);
                }
            }
        }
        return result;
    }

    public Estrazione estrai(String testoEstrazione) throws Exception {
        Estrazione result = new Estrazione();
        if (Eval.isNotEmpty(testoEstrazione)) {
            testoEstrazione = prepare(testoEstrazione);
            StringTokenizer tkz = new StringTokenizer(testoEstrazione, "( )*");
            Ruota ruota = null;
            while (tkz.hasMoreTokens()) {
                String tkn = tkz.nextToken().trim();
                if (Eval.isNotEmpty(tkn)) {
                    if (tkn.matches("[a-zA-Z]*")) {
                        ruota = new Ruota(tkn);
                        ruota.setData(result.getData());
                        result.addRuota(ruota);
                    } else if (tkn.matches("[0-9]*")) {
                        Integer numero = Integer.valueOf(tkn);
                        Ruota r = result.getRuota(ruota.getCitta().getNome());
                        r.addNumero(numero);
                    }
                }
            }
        }

        return result;
    }

    private static final String prepare(String testoEstrazione) {
        String result = testoEstrazione.toLowerCase().trim();
        for (Citta c : citta) {
            if (result.contains(c.getNome().toLowerCase())) {
                result = result.replaceAll(c.getNome().toLowerCase(), " " + c.getNome().toLowerCase() + " ");
            }
        }
        System.out.println("result = " + result);
        return result;
    }

}
