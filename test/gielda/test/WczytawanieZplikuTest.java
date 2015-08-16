package gielda.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gielda.dostepDoDanych.repository.OdczytZPliku;
import gielda.dostepDoDanych.repository.Records;
import gielda.dostepDoDanych.repository.RecordsImpl;


public class WczytawanieZplikuTest {	
	
	String fileName = "dane.csv";
	RecordsImpl impl;
	Records baza;
	
	@Before
	public void befor() throws IOException {	
		baza=OdczytZPliku.read(fileName);
		impl = new RecordsImpl();
	}
	
		
	
@Test
	public void shouldLoadAll5stock() throws IOException {
	
	 
		Assert.assertEquals(5, (impl.getAll()).size());
		
	}
@Test
public void shoulcheckNameOfFirstStock() {
	
}

	
	
	
}
