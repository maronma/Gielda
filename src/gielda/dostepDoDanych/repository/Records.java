package gielda.dostepDoDanych.repository;

import java.util.Date;
import java.util.List;

import gielda.entity.Record;

public interface Records {

	List<Record> getAllByName(String name);

	Record getSpecific(String name, Date data);

	List<Record> getAllByDate(Date data);

	int getsize();

}
