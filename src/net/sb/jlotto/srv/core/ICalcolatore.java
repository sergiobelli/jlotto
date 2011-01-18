package net.sb.jlotto.srv.core;

import java.util.List;
import net.sb.jlotto.srv.core.model.CarattereValore;
import net.sb.jlotto.srv.core.model.Citta;
import net.sb.jlotto.srv.core.model.Estrazione;
import net.sb.jlotto.srv.core.model.Ruota;

public interface ICalcolatore {

	String ERR_CARATTERE_NON_VALIDO = "Lettera/carattere specificato non presente";
	CarattereValore[] valori = Constants.valori;
        Citta[] citta = Constants.citta;

	Integer calcola(String lettere);

        List<Ruota> filtra(Estrazione estrazione, Integer numero);

	Estrazione estrai(String testoEstrazione) throws Exception;
	
}