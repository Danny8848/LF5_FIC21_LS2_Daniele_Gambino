import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		int zuZahlenderBetrag;
		double zuZahlenBetrag;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen;
		double AnzahlDerTickets;
		double zwischensumme;
		double zwischenergebenis;
		
		zwischensumme = 0;
		zuZahlenBetrag = 0;
		zuZahlenderBetrag=0;
		while (zuZahlenderBetrag!=9) {
			// Geldbetrag eingeben
			System.out.print("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:\n");
			System.out.print("	Kurzstrecke AB [2,00 EUR] (1)\n");
			System.out.print("	Einzelfahrschein AB [3,00 EUR] (2)\n");
			System.out.print("	Tageskarte AB [8,80 EUR] (3)\n");
			System.out.print("	4-Fahrten-Karte AB [9,40 EUR] (4)\n");
			System.out.print("	Bezahlen (9)\n\n");
		
			zuZahlenderBetrag=0;
			zuZahlenBetrag = 0;
			while (zuZahlenderBetrag>4||zuZahlenderBetrag<1) {
				System.out.print("Ihre Wahl: ");
				zuZahlenderBetrag = tastatur.nextInt();
				if (zuZahlenderBetrag!=9) {
				switch(zuZahlenderBetrag) {
					case 1:
						zuZahlenBetrag = 2;
						break;
					case 2:
						zuZahlenBetrag = 3;
						break;
					case 3:
						zuZahlenBetrag = 8.8;
						break;
					case 4:
						zuZahlenBetrag = 9.4;
						break;
					default:
						System.out.print("	>>falsche Eingabe<<\n");
						
				}
				AnzahlDerTickets = 0;
				while (AnzahlDerTickets>10||AnzahlDerTickets<1) {
					System.out.print("Anzahl der Tickets: ");
					AnzahlDerTickets = tastatur.nextDouble();
					if (AnzahlDerTickets>10||AnzahlDerTickets<1) {
						System.out.println(">> Wählen sie bite eine Anzahl von 1 bis 10 Tickets aus. \n");
					}
				}
				zwischenergebenis = zuZahlenBetrag*AnzahlDerTickets;
				zwischensumme = zwischensumme + zwischenergebenis;
				System.out.printf("Zwischensumme: %.2f€\n",zwischensumme);
				
				}
				else {
					eingezahlterGesamtbetrag = 0.0;
					nochZuZahlen = 0.0;
					while (eingezahlterGesamtbetrag < zwischensumme) {
						nochZuZahlen = zwischensumme - eingezahlterGesamtbetrag;
						System.out.printf("Noch zu zahlen: %.2f Euro\n",nochZuZahlen); //hier gab es einen änderung von mir sah vorher anders aus kann ich nichtmehr herstellen
						System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
						eingeworfeneMuenze = tastatur.nextDouble();
						if (!(eingeworfeneMuenze==0.05||eingeworfeneMuenze==0.1||eingeworfeneMuenze==0.2||eingeworfeneMuenze==0.5||eingeworfeneMuenze==1||eingeworfeneMuenze==2||eingeworfeneMuenze==5||eingeworfeneMuenze==10||eingeworfeneMuenze==20)) {
							System.out.println(">> Kein gültiges Zahlungsmittel");
						}
							else {
								eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
						}
					}
					
					// Fahrscheinausgabe
					System.out.println("\nFahrschein wird ausgegeben");
					for (int i = 0; i < 8; i++) {
						System.out.print("=");
						try {
							Thread.sleep(200);
						} 
						catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("\n\n");
					
					// Rückgeldberechnung und -ausgabe
					rueckgabebetrag = eingezahlterGesamtbetrag - zwischensumme;
					if (rueckgabebetrag > 0.0) {
						System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n",rueckgabebetrag); //hier wurde auch eine änderung durchgeführt
						System.out.println("wird in folgenden Münzen ausgezahlt:");

						while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
							System.out.println("2 Euro");
							rueckgabebetrag = rueckgabebetrag - 2.0;
						}
						while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
							System.out.println("1 Euro");
							rueckgabebetrag = rueckgabebetrag - 1.0;
						}
						while (rueckgabebetrag >= 0.49) { // 50-Cent-Münzen
							System.out.println("50 Cent");
							rueckgabebetrag = rueckgabebetrag - 0.5;
						}
						while (rueckgabebetrag >= 0.19) { // 20-Cent-Münzen
							System.out.println("20 Cent");
							rueckgabebetrag = rueckgabebetrag - 0.2;
						}
						while (rueckgabebetrag >= 0.09) { // 10-Cent-Münzen
							System.out.println("10 Cent");
							rueckgabebetrag = rueckgabebetrag - 0.1;
						}
						while (rueckgabebetrag >= 0.04) { // 5-Cent-Münzen
							System.out.println("5 Cent");
							rueckgabebetrag = rueckgabebetrag - 0.05;	
						}
					}
					break;
				}
			
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
}