package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int postiTotale;
		LocalDate data;
		String titolo = "";
		boolean stop = false;
		String risposta;
		int postiPrenotati;

		System.out.print("Inserisci il titolo dell'evento:");
		titolo = scanner.nextLine();

		System.out.print("Inserisci il numero di posti disponibili per questo evento: "); 
		postiTotale = scanner.nextInt();

		System.out.print("Inserisci il giorno dell'evento: ");
		int giorno = scanner.nextInt();
		System.out.print("Inserisci il mese: ");
		int mese = scanner.nextInt();
		System.out.print("Inserisci l'anno: ");
		int anno = scanner.nextInt();
		LocalDate dataEvento = LocalDate.of(anno, mese, giorno);

		try {
			Evento evento = new Evento(titolo, dataEvento, postiTotale);
			System.out.println("Hai creato l'evento: " + titolo + " in data " + dataEvento);
			System.out.println("I posti disponibili in totale saranno: " + postiTotale);

			System.out.print("Procedere con una prenotazione? (s/n)");
			scanner.nextLine();
			do {
				risposta = scanner.nextLine();
				if (risposta.equals("s")) {
					stop = true;
				} else if (risposta.equals("n")) {
					System.out.println("Grazie per aver utilizzato il programma.");
				} else {
					System.out.println("Errore, inserire un valore corretto (s/n)");
				}

			} while (stop == false);
			System.out.print("Inserire quante prenotazioni si vogliono effettuare: ");
			int prenotazioni = scanner.nextInt();
			for (int i = 0; i < prenotazioni; i++) {
				evento.prenota();
			}
			System.out.println("In totale ci sono: " + prenotazioni + " posti prenotati" + " e "
					+ (postiTotale - prenotazioni) + " posti ancora disponibii.");

			stop = false;
			System.out.print("Disdire qualche prenotazione? (s/n)");
			scanner.nextLine();
			do {
				risposta = scanner.nextLine();
				if (risposta.equals("s")) {
					stop = true;
				} else if (risposta.equals("n")) {
					System.out.println("Grazie per aver usato il programma");
				} else {
					System.out.println("Errore, inserire un valore corretto (s/n)");
				}
			} while (stop == false);
			System.out.print("Inserire quante prenotazioni si vogliono disdire: ");
			int disdette = scanner.nextInt();
			for (int i = 0; i < disdette; i++) {
				evento.disdici();
			}
			System.out.println("Hai disdetto " + disdette + " prenotazioni.");
			System.out.println("Al momento ci sono: " + (prenotazioni - disdette) + " posti prenotati e "
					+ ((postiTotale - prenotazioni) + disdette) + " posti ancora disponibili");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		scanner.close();
	}
}