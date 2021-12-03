package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	// attributi
	private String titolo;
	private LocalDate data;
	private int postiTotale;
	private int postiPrenotati;

	// costruttore
	public Evento(String titolo, LocalDate data, int postiTotale) throws Exception {

		this.postiPrenotati = 0;
		this.titolo = titolo;
		
		if (data.isAfter(LocalDate.now())) {
			this.data = data;
		} else {
			throw new Exception("Errore: data non valida");
		}
		if (postiTotale > 0) {
			this.postiTotale = postiTotale;
		} else {
			throw new Exception("Errore: il numero dei posti totali deve essere maggiore di zero");
		}

	}

	// getter e setter
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTotale() {
		return postiTotale;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	// metodi public

	public void prenota() throws Exception {
		
		if (!data.isAfter(LocalDate.now())) {
			throw new Exception("La data è passata");
		} else if (postiPrenotati == postiTotale) {
			throw new Exception("I posti disponibili sono finiti");
		} else {
			this.postiPrenotati++;
		}
	}

	public void disdici() throws Exception {
		if (!data.isAfter(LocalDate.now())) {
			throw new Exception("La data è passata");
		} else if (postiPrenotati == 0) {
			throw new Exception("Non ci sono prenotazioni");
		} else {
			this.postiPrenotati--;
		}
	}

	@Override
	public String toString() {
		String dataFormattata;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormattata = this.data.format(df);
		return dataFormattata + " - " + this.titolo;
	}

}
