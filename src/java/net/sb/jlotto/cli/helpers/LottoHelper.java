package net.sb.jlotto.cli.helpers;

import net.sb.jlotto.shr.Eval;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.sb.jlotto.srv.core.Calcolatore;
import net.sb.jlotto.srv.core.ICalcolatore;
import net.sb.jlotto.srv.core.model.Estrazione;
import net.sb.jlotto.srv.core.model.Ruota;

/**
 * @author sbelli
 */
public class LottoHelper {

    private     final ICalcolatore  calcolatore = new Calcolatore();
    protected   final FileHandler   fileHandler = new FileHandler();
    protected   final Logger        logger      = Logger.getLogger(this.getClass().getName());

    public Integer calcola(String parola) {
        logger.info("Richiesto calcolo per seguente parola : " + parola);
        Integer result = calcolatore.calcola(parola);
        logger.info("Risultato : " + result);
        return result;
    }

    public Estrazione estrai(String testo) {
        logger.info("Richiesta estrazione per seguente testo : " + testo);
        Estrazione result = null;
        try {
            result = calcolatore.estrai(testo);
            fileHandler.writeFile(result);
            logger.info("Risultato : " + result);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public final void renderEstrazione(JTable tabella, Estrazione estrazione, List<Integer> numeri) {
        if (Eval.isNotNull(estrazione)) {
            int riga = 0;
            for (Ruota ruota : estrazione.getRuote()) {
                try {
                    if (Eval.isNotEmpty(ruota.getCitta().getNome())) {
                        String nome = ruota.getCitta().getNome();
                        tabella.setValueAt(nome, riga, 0);
                        for (int posizione = 0,colonna = 1 ; posizione < 5; posizione++,colonna++) {
                            Integer numero = ruota.getNumeri().get(posizione);
                                tabella.setValueAt(numero, riga, colonna);
                                if (Eval.isNotNull(numeri)
                                        && numeri.contains(numero)) {
                                    tabella.setValueAt("[["+numero+"]]", riga, colonna);
                                }
                        }
                    }
                    riga++;
                } catch (Exception ex) {
                    logger.log(Level.SEVERE, null, ex);
                }
            }
        } else {
            for (int i = 0; i < tabella.getRowCount(); i++) {
                tabella.setValueAt("", i, 0);
                tabella.setValueAt("", i, 1);
                tabella.setValueAt("", i, 2);
                tabella.setValueAt("", i, 3);
                tabella.setValueAt("", i, 4);
                tabella.setValueAt("", i, 5);
            }
        }
    }

    public void cancellaEstrazione() {
        logger.info("Richiesta cancellazione estrazione.");
        try {
            Estrazione estrazione = fileHandler.readFile();
            estrazione.clean();
            fileHandler.writeFile(estrazione);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        logger.info("Cancellazione eseguita positivamente.");
    }
    
}
