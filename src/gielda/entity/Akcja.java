package gielda.entity;

import java.util.Date;

public class Akcja {

	String name;
	int iloscAkcji;
	Date dzienKupna;
	float cenaWdniuKupna;

	public Akcja() {
	};

	public Akcja(String name, int iloscAkcji, Date dzienKupna, float cenaWdniuKupna) {
		this.name = name;
		this.iloscAkcji = iloscAkcji;
		this.dzienKupna = dzienKupna;
		this.cenaWdniuKupna = cenaWdniuKupna;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIloscAkcji() {
		return iloscAkcji;
	}

	public void setloscAkcji(int iloscAkcji) {
		this.iloscAkcji = iloscAkcji;
	}

	public Date getDzienKupna() {
		return dzienKupna;
	}

	public void setDzienKupna(Date dzienKupna) {
		this.dzienKupna = dzienKupna;
	}

	public Float getCenaWdniuKupna() {
		return cenaWdniuKupna;
	}

	public void setCenaWdniuKupna(Float cenaWdniuKupna) {
		this.cenaWdniuKupna = cenaWdniuKupna;
	}

	public float getAktualnaCena(Float currVal) {
		return currVal * iloscAkcji;

	}
}
