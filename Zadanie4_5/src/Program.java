public class Program
{
    public static void main(String[] args)
    {
        Osoba W = new Osoba("Jan", "Kowalski", 1800);
        Osoba X = new Osoba("Edyta", "Gorniak", 1700);
        Osoba Z = new Osoba("Bob", "Bobowski", 1879);
        Osoba A = new Osoba("Kasia", "GORNIAK", 1990);
        Osoba B = new Osoba("Andrzej", "gOrniaK", 2002);
        Osoba C = new Osoba("Julian", "Kot", 2022);


        Dokument[] bazaDanych={new Paszport(W), new DowodOsobisty(X), new Paszport(Z), new DowodOsobisty(A), new Paszport(B), new DowodOsobisty(C)};

        Dokument z;
        String wzorzec="Gorniak";

        for(int i=0;i<bazaDanych.length;i++)
        {
            z=bazaDanych[i];
            if(z.czyPasuje(wzorzec))System.out.println("znaleziono: "+z);
        }
    }
}
