package gielda.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Record {
	private String firma;
	private Date data;
	private float cena;

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public Record(String firma, Date data, float cena) {

		this.firma = firma;
		this.data = data;
		this.cena = cena;
	}

	public Record() {

	}

	public Record(String readline) {

		Record toReturn = null;

		try {
			String[] dane = readline.split(",");
			DateFormat format = new SimpleDateFormat("yyyymmdd", Locale.ENGLISH);

			this.firma = dane[0];
			this.data = format.parse(dane[1]);
			this.cena = Float.parseFloat(dane[2]);

//			 System.out.println("Wczytano" +toReturn.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		// return "Akcja [firma=" + firma + ", " + ", cena=" + cena + "]";
		return "Akcja [firma=" + firma + ", data=" + df.format(data) + ", cena=" + cena + "]";
	}

}
