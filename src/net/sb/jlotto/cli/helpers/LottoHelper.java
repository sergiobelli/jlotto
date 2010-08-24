package net.sb.jlotto.cli.helpers;

import net.sb.jlotto.srv.core.Calcolatore;
import net.sb.jlotto.srv.core.ICalcolatore;

/**
 * @author sbelli
 */
public class LottoHelper {

    private final ICalcolatore calcolatore = new Calcolatore();

    public Integer calcola(String parola) {
        return calcolatore.calcola(parola);
    }
}
