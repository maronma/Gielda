package gielda.dostepDoDanych.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gielda.entity.Record;

public class RecordsImpl implements Records {

	List<Record> values;

	public RecordsImpl() {

		values = new ArrayList<Record>();

	}

	public void add(Record toAdd) {
		values.add(toAdd);

	}
	@Override
	public List<Record> getAllByName(String name) {

		List<Record> toReturn = new ArrayList<Record>();

		for (Record checked : values) {
			if (checked.getFirma().equals(name))
				toReturn.add(checked);

		}
		return toReturn;

	}
	@Override
	// Jeżeli dotyczy firmy akcji (current) z portfela
	public Record getSpecific(String name, Date data) {
		List<Record> wybor = this.getAllByDate(data);
		for (Record curRecord : wybor) {
			if (curRecord.getFirma().equals(name))
				return curRecord;
		}
		return null;

	}

	public List<Record> getAll() {

		return values;

	}
	@Override
	public List<Record> getAllByDate(Date data) {
		List<Record> toReturn = new ArrayList<Record>();
		// System.out.println("Wybieram dane z liczby:" + values.size());
		for (Record checked : values) {
			if (checked.getData().equals(data))
				toReturn.add(checked);
		}
		return toReturn;

	}
	@Override
	public int getsize(){
		return values.size();
	}

}
