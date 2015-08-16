package gielda.logikaBiznesowa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import gielda.dostepDoDanych.repository.Records;
import gielda.entity.Akcja;
import gielda.entity.Portfel;
import gielda.entity.Record;

public class OperacjaImpl implements Operacja {
	static double prowizja = 1.05;
	
	
//	List<Akcja> syncAkcja = Collections.synchronizedList(new ArrayList<Akcja>());
//	
//			synchronized (syncAkcja) {
//				Iterator<Akcja> iterator = syncAkcja.iterator();
//				while (iterator.hasNext()) {
//					System.out.println("item: " + iterator.next());
//				}
//			}
@Override
	public  void kupLosowoAkcje(double procent, Portfel portfel, Records baza, Date startDate) {
		List<Record> aktualneRecordy = baza.getAllByDate(startDate);

		Random generator = new Random();

		int luckyNumber = 0;

		luckyNumber = generator.nextInt(aktualneRecordy.size());

		double fundusze = portfel.getGotowka() * procent;
		int ileAkcjiKupic = (int) (fundusze / (aktualneRecordy.get(luckyNumber).getCena() * prowizja));

		double kosztKupionychAkcji = aktualneRecordy.get(luckyNumber).getCena() * prowizja * ileAkcjiKupic;

		portfel.wydajGotowke(kosztKupionychAkcji);
		portfel.dodajAkcje(aktualneRecordy.get(luckyNumber).getFirma(), ileAkcjiKupic,
				aktualneRecordy.get(luckyNumber).getCena(), startDate);

	}
@Override
	public  void sprawdzIZlecSprzedaz(Portfel portfel, Records baza, Date currentDate) {
	
		for (Akcja current : portfel.getAkcje()) {
			if(current!=null)
			
			if (czyOplacaSieSprzedac(current, baza, currentDate)){
//				System.out.println("Sprzedano akcje:"+ current.getName());
				sprzedajAkcje(portfel, current, baza, currentDate);
				System.out.println();
			}

//			System.out.println("Nie zrobilo nic dla akcji "+current. getName());
		}
	}

@Override
	  public void sprzedajAkcje(Portfel portfel, Akcja current, Records baza, Date currentDate) {
//		System.out.println("Sprzedaje akcje firmy" + current.getName() + current.getIloscAkcji() +"po cenie" +current.getAktualnaCena(null));
		float cenaAkcji =  baza.getSpecific(current.getName(), currentDate).getCena();
		int liczbaPosiadanychAkcji = current.getIloscAkcji();
		portfel.dodajFundusze(cenaAkcji * liczbaPosiadanychAkcji);
		
		//Usun akcje z portfela
		System.out.println("Sprzedano akcje: "+ current.getName()+" (ilosc akcji "+liczbaPosiadanychAkcji+")"+" po cenie: "+current.getAktualnaCena(cenaAkcji));
		System.out.println(portfel.toString());
		portfel.usunAkcje(current);
		System.out.println(portfel.toString());
		
	}
	@Override
	public boolean czyOplacaSieSprzedac(Akcja current, Records baza, Date currentDate) {

		 // Jeżeli dotyczy firmy akcji current z portfela				
				Record curRecord = baza.getSpecific(current.getName(), currentDate);				
				double cenaZakupuIProw = current.getCenaWdniuKupna() * 1.02;
				if(curRecord!=null)
				if (curRecord.getCena() >= cenaZakupuIProw) // Jeżeli aktualna cena >= 1.1 pierwotnej
					return true;
		

		return false;
	}
	
	@Override
	public  void kupCoTrzeba(Portfel portfel, Records baza, Date currentDate) {
		// TODO Auto-generated method stub

	}

}
