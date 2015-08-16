package gielga.view;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import gielda.dostepDoDanych.repository.OdczytZPliku;
import gielda.dostepDoDanych.repository.Records;
import gielda.entity.Portfel;
import gielda.logikaBiznesowa.service.Operacja;
import gielda.logikaBiznesowa.service.OperacjaImpl;

public class Main {
	static Date currentDate;
	
	
	public static void main(String[] args) {

		try {
			int gotowkaPoczatkowa = 10000;
			String fileName = "dane.csv";
			
			Records baza = OdczytZPliku.read(fileName);
			Portfel portfel = new Portfel(gotowkaPoczatkowa);
			Operacja operacja= new OperacjaImpl();
			
			DateFormat format = new SimpleDateFormat("yyyymmdd", Locale.ENGLISH);			
			String dataStart = "20130102";// yyyymmdd			
			Date startDate = format.parse(dataStart);
//			currentDate= startDate;
//			Date endDate = baza.getAll().get(baza.getAll().size()-1).getData();
//			Date endDate = format.parse("20131230");

		
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//			Date startDate = formatter.parse("2013-01-02");
			Date endDate = formatter.parse("2013-02-31");
			
			Calendar start = Calendar.getInstance();
			start.setTime(startDate);
			Calendar end = Calendar.getInstance();
			end.setTime(endDate);
			
			operacja.kupLosowoAkcje(0.2, portfel, baza, startDate);
			operacja.kupLosowoAkcje(0.2, portfel, baza, startDate);
			operacja.kupLosowoAkcje(0.2, portfel, baza, startDate);
			operacja.kupLosowoAkcje(0.2, portfel, baza, startDate);

			for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
				operacja.sprawdzIZlecSprzedaz(portfel, baza, date);
				operacja.kupCoTrzeba(portfel, baza, date);
			    System.out.println(date.getMonth()+" "+date.getDate());
//			    System.out.println(date);
			    
			}
			
			
			
//		
				
				
				
				
				
			


			// Opłacalność

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Date nextDay(Date currentDate) {
		DateFormat format = new SimpleDateFormat("yyyymmdd", Locale.ENGLISH);
		Calendar c = Calendar.getInstance(); 
		c.setTime(currentDate); 
		c.add(Calendar.DATE, 1);
		currentDate = c.getTime();
		
		return currentDate;
	}

	
}