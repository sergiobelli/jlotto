/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sb.jlotto.srv.core.model;

/**
 *
 * @author sbelli
 */
public class Citta implements JLottoModel {

    private String targa;
    private String nome;

    public Citta(){}
    public Citta(String targa, String nome){
        setTarga(targa);
        setNome(nome);
    }

    /**
     * @return the targa
     */
    public String getTarga() {
        return targa;
    }

    /**
     * @param targa the targa to set
     */
    public void setTarga(String targa) {
        this.targa = targa;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
