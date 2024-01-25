abstract class Dokument implements Przeszukiwalne{
// czym sie rozni klasa abstrakcyjna od interfaceu

    // Klasa abstrakcyjna moze miec i abstrakcyjne i nie abstrakcyjne metody
    // a Interface moze miec tylko metody abstrakcyjne
    Osoba o;
    Dokument(Osoba o){
        this.o = o;
    }

    public boolean czyPasuje(String wzorzec)
    {
        return o.nazwisko.equalsIgnoreCase(wzorzec);
    }
}
