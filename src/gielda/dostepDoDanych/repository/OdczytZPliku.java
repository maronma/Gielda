package gielda.dostepDoDanych.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import gielda.entity.Record;

public class OdczytZPliku {

	public static RecordsImpl read(String fileName) throws IOException {
		Scanner scanner = null;
		String line = "";
		RecordsImpl fromExcel = new RecordsImpl();
		try {

			scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				String readline = scanner.nextLine();
				fromExcel.add(new Record(readline));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return fromExcel;
	}

}