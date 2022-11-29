public class DoppelteBuchfuehrung {
    public static void main (String[] args)
    {
        // Create Bestandskonten
        // aktivkonten
        Konto Eigenkapital = new Konto("Eigenkapital","aktiv");
        Konto Spenden = new Konto("Spenden","aktiv");

        // passivkonten
        Konto Bankkonto = new Konto("Bankkonto","passiv");
        Konto Kasse = new Konto("Kasse","passiv");

        // Create Buchungen Anfangskapital
        Buchung Anfangskapital1 = new Buchung(100);
        Buchung Anfangskapital2 = new Buchung(50);

        // Buchen auf Bestandskonten aufteilen
        // aktivkonten
        Bankkonto.addSollBuchung(Anfangskapital1);
        Eigenkapital.addHabenBuchung(Anfangskapital1);

        // passivkonten
        Kasse.addSollBuchung(Anfangskapital2);
        Eigenkapital.addHabenBuchung(Anfangskapital2);

        // Create Erfolgskonten
        Konto Aufwandskonto = new Konto("Aufwandskonto", "Erfolgskonto");
        Konto Ertragskonto = new Konto("Ertragskonto", "Erfolgskonto");

        // Create Buchungen Erfolgskonten
        Buchung Aufwand = new Buchung(10);
        Buchung Ertrag = new Buchung(50);

        // Buchungen auf Konten aufteilen
        Aufwandskonto.addSollBuchung(Aufwand);
        Bankkonto.addHabenBuchung(Aufwand);

        Ertragskonto.addHabenBuchung(Ertrag);
        Kasse.addSollBuchung(Ertrag);

        // Create Gewinn und Verlustkonto
        Konto GuV = new Konto("Geschäftsjahr","GuV");

        Aufwandskonto.Bilanz(GuV);
        Ertragskonto.Bilanz(GuV);

        GuV.Bilanz(Eigenkapital);

        System.out.println(GuV.getSaldo());
        // Create Schlussbilanzkonto
        Konto Schlussbilanzkonto = new Konto("diesesJahr","Schlussbilanzkonto");

        // Werte Schlussbilanz mit alle erstellen Konten aus
        Eigenkapital.Bilanz(Schlussbilanzkonto);
        Spenden.Bilanz(Schlussbilanzkonto);
        Bankkonto.Bilanz(Schlussbilanzkonto);
        Kasse.Bilanz(Schlussbilanzkonto);


        // Überprüfe ob Schlussbilanz 0 ist!
        System.out.println(Schlussbilanzkonto.getSaldo());

        System.out.println(Schlussbilanzkonto.BilanzToString());

    }
}
