package net.sb.jlotto.cli.helpers;

import net.sb.jlotto.shr.Eval;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.sb.jlotto.srv.core.model.Estrazione;
import net.sb.jlotto.srv.core.model.Ruota;

/**
 * @author sbelli
 */
public class LottoEstrazioneHelper extends LottoHelper {

    public void inserisciEstrazione(JTable tabella, JTextArea areaTesto) {
        logger.info("Richiesto inserimento estrazione.");
        String testoEstrazione = areaTesto.getText();
        logger.info("Testo estrazione : " + testoEstrazione);

        Estrazione estrazione = estrai(testoEstrazione);
        logger.info("Estrazione : " + estrazione);

        renderEstrazione(tabella, estrazione, null);

        logger.info("Inserimento estrazione avvenuto con successo.");
    }

    public void cancellaEstrazione(JTable tabella) {
        logger.info("Richiesta cancellazione estrazione.");
        cancellaEstrazione();
        renderEstrazione(tabella, null, null);
        logger.info("Cancellazione estrazione avvenuta con successo.");
    }

    public void trovaRuote(JTable tabella, JTextField campoTesto) {
        Estrazione estrazione = null;

        try {
            estrazione = fileHandler.readFile();

            Estrazione newEstrazione = new Estrazione();
            newEstrazione.setData(estrazione.getData());

            List<Integer> numeriRicercati =
                    preparaTestoInserito(campoTesto.getText().toUpperCase());
            if (Eval.isNotEmpty(numeriRicercati)) {
                for (Ruota ruota : estrazione.getRuote()) {
                    for (Integer numero : numeriRicercati) {
                        if (ruota.getNumeri().contains(numero)) {
                            newEstrazione.addRuota(ruota);
                        }
                    }
                }
                renderEstrazione(tabella, null, null);
                renderEstrazione(tabella, newEstrazione, numeriRicercati);
            } else {
                renderEstrazione(tabella, estrazione, null);
            }

        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    private List<Integer> preparaTestoInserito(String testoInserito) {
        logger.info("[LottoEstrazioneHelper.preparaTestoInserito] inizio "
                + "con testo inserito = " + testoInserito);
        List<Integer> result = new ArrayList<Integer>();
        if (Eval.isNotEmpty(testoInserito)) {
            if (testoInserito.contains(",")) {
                StringTokenizer tkz = new StringTokenizer(testoInserito, ",");
                while (tkz.hasMoreTokens()) {
                    String tkn = tkz.nextToken();
                    if (Eval.isNotEmpty(tkn)) {
                        result.add(Integer.valueOf(tkn));
                    }
                }
            } else {
                result.add(Integer.valueOf(testoInserito));
            }
        }
        logger.info("[LottoEstrazioneHelper.preparaTestoInserito] result = " + result);
        return result;
    }
}
