package gielda.logikaBiznesowa.service;

import java.util.Date;

import gielda.dostepDoDanych.repository.Records;
import gielda.entity.Akcja;
import gielda.entity.Portfel;

public interface Operacja {

	
	 void kupLosowoAkcje(double procent, Portfel portfel, Records baza, Date startDate) ;

	void sprawdzIZlecSprzedaz(Portfel portfel, Records baza, Date currentDate);

	void sprzedajAkcje(Portfel portfel, Akcja current, Records baza, Date currentDate);

	boolean czyOplacaSieSprzedac(Akcja current, Records baza, Date currentDate);

	void kupCoTrzeba(Portfel portfel, Records baza, Date currentDate);
}
