package net.sb.jlotto.srv.core.model;

public 	class CarattereValore implements JLottoModel {
	private String lettera;
	private Integer valore;
	public CarattereValore(String lettera,Integer valore) {
		setLettera(lettera);
		setValore(valore);
	}
	public String getLettera() {return lettera;}
	public void setLettera(String lettera) {this.lettera = lettera;}
	public Integer getValore() {return valore;}
	public void setValore(Integer valore) {this.valore = valore;}
}
