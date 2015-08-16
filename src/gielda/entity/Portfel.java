package gielda.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Portfel {
	double gotowka;
	List<Akcja> akcja;
	
	
	public Portfel(int gotowkaPoczatkowa) {
		this.akcja= new ArrayList<Akcja>();
		this.gotowka = gotowkaPoczatkowa;		
	}
	public Portfel(){}
	
	

	public double getGotowka() 
	{
		return gotowka;
	}

	public void setGotowka(double gotowka) {
		this.gotowka = gotowka;
	}

	public List<Akcja> getAkcje() {
		return akcja;
	}

	public void setAkcje(List<Akcja> akcje) {
		this.akcja = akcje;
	}
	public void wydajGotowke(double kosztKupionychAkcji) {
		gotowka=gotowka - kosztKupionychAkcji;
		
	}
	public void dodajAkcje(String nazwa, int liczba, float cena, Date dataZakupu) {
		
		akcja.add(new Akcja(nazwa, liczba, dataZakupu, cena));
		
		
		System.out.println("Kupiono akcje firmy " +nazwa+ " w ilosci " + liczba + " w cenie "+ cena );
	}
	public void dodajFundusze(double d) {
		gotowka+=d;
		
	}
	public void usunAkcje(Akcja current) {
		int index =0;
		
		for(int i=0;i<akcja.size();i++)
		{
			if(akcja.get(i).equals(current))
			index=i;
		}
		
		akcja.remove(index);
		
	}
	@Override
	public String toString() {
		return "Portfel [gotowka=" + gotowka + ", akcja=" + akcja + "]";
	}

	

}
