package gielda.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import gielda.dostepDoDanych.repository.Records;
import gielda.dostepDoDanych.repository.RecordsImpl;
import gielda.entity.Akcja;
import gielda.entity.Portfel;
import gielda.entity.Record;
import gielda.logikaBiznesowa.service.Operacja;
import gielda.logikaBiznesowa.service.OperacjaImpl;

public class OperacjeTest {

	Operacja operacja;
	RecordsImpl impl;
	Record dodajakcje;
	String firma;
	Date data;
	float cena;

	@Before
	public void initTest() {
		operacja = new OperacjaImpl();
		impl = new RecordsImpl();
		dodajakcje = new Record(firma, data, cena);
	}

	@Test
	public void shouldLoadNextStock() {
	}

	@Test
	public void shouldkupLosowoAkcje(double procent, Portfel portfel, Records baza, Date startDate) {
	};

	@Test
	public void shouldsprawdzIZlecSprzedaz(Portfel portfel, Records baza, Date currentDate) {
	};

	@Test
	public void shouldsprzedajAkcje(Portfel portfel, Akcja current, Records baza, Date currentDate) {
	};

	@Test
	public void shouldczyOplacaSieSprzedac(Akcja current, Records baza, Date currentDate) {
	};

	@Test
	public void shouldkupCoTrzeba(Portfel portfel, Records baza, Date currentDate) {
	};

}
