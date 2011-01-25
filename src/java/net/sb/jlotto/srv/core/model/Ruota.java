/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sb.jlotto.srv.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sb.jlotto.shr.Eval;

/**
 *
 * @author sbelli
 */
public class Ruota implements JLottoModel, Comparable<Ruota> {

    private Citta citta;
    private List<Integer> numeri;
    private Date data;

    public Ruota() {
    }

    public Ruota(String tkn) {
        setCitta(new Citta(tkn, tkn));//FIXME:completare bene!!!
    }

    public Ruota(Citta citta, List<Integer> numeri) {
        setCitta(citta);
        setNumeri(numeri);
    }

    public Ruota(Citta citta, Integer... numeri) {
        setCitta(citta);
        List<Integer> rs = new ArrayList<Integer>();
        for (Integer ruota : numeri) {
            rs.add(ruota);
        }
        setNumeri(rs);
    }

    /**
     * @return the citta
     */
    public Citta getCitta() {
        return citta;
    }

    /**
     * @param citta the citta to set
     */
    public void setCitta(Citta citta) {
        this.citta = citta;
    }

    /**
     * @return the numeri
     */
    public List<Integer> getNumeri() {
        return numeri;
    }

    /**
     * @param numeri the numeri to set
     */
    public void setNumeri(List<Integer> numeri) {
        this.numeri = numeri;
    }

    public void addNumero(Integer numero) {
        if (Eval.isEmpty(this.getNumeri())) {
            this.setNumeri(new ArrayList<Integer>());
        }
        this.getNumeri().add(numero);
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    public int compareTo(Ruota t) {
        if (this.getCitta().getNome().equals(t.getCitta().getNome())) {
            return 0;
        } else {
            return this.getCitta().getNome().compareTo(t.getCitta().getNome());
        }
    }
}
