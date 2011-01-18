/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sb.jlotto.srv.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author sbelli
 */
public class Estrazione implements JLottoModel {

    private Date data;
    private TreeSet<Ruota> ruote = new TreeSet<Ruota>();

    public Estrazione() { }

    public Estrazione(Date data, TreeSet<Ruota> ruote) {
        setData(data);
        setRuote(ruote);
    }

    public Estrazione(Date data, Ruota... ruote) {
        setData(data);
        TreeSet<Ruota> rs = new TreeSet<Ruota>();
        for (Ruota ruota : ruote) {
            rs.add(ruota);
        }
        setRuote(rs);
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

    /**
     * @return the ruote
     */
    public TreeSet<Ruota> getRuote() {
        return this.ruote;
    }

    /**
     * @param ruote the ruote to set
     */
    public void setRuote(TreeSet<Ruota> ruote) {
        this.ruote = ruote;
    }

    public void addRuota(Ruota ruota) {
        if (this.getRuote()==null) {
            this.setRuote(new TreeSet<Ruota>());
        }
        this.getRuote().add(ruota);
    }

    public Ruota getRuota(String targaONome) {
        for (Ruota ruota : this.getRuote()) {
        	if (targaONome.equalsIgnoreCase(ruota.getCitta().getTarga())
        			|| targaONome.equalsIgnoreCase(ruota.getCitta().getNome())) {
        		return ruota;
        	}
        }
        return null;
    }

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Data : ").append(this.getData()).append("\n");
		if (this.getRuote() != null) {
			for (Ruota ruota : this.getRuote()) {
				buf.append(ruota.getCitta().getNome()).append(" ").append(ruota.getNumeri()).append("\n");
			}
		}
		return buf.toString();
	}

    public void getRuota(int i) {

    }

    public void clean() {
        this.setData(null);
        this.setRuote(null);
    }


}