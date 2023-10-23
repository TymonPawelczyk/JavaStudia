public class Program {
    public static void main(String[] args) {
        Ulamek obj, obj2;
        obj = new Ulamek(6, 8);
        obj2 = new Ulamek(3, 7);

        System.out.println(obj);
        System.out.println(obj2);

        double x = obj.rozwDziesietne();
        System.out.println(x);

        Ulamek sumaUl = obj.plus(obj2);
        Ulamek roznicaUl = obj.minus(obj2);
        Ulamek iloczynUl = obj.razy(obj2);

        System.out.println("Suma: " + sumaUl);
        System.out.println("Różnica: " + roznicaUl);
        System.out.println("Iloczyn: " + iloczynUl);

        LiczbaZespolona liczba1 = new LiczbaZespolona(3.0, 4.0);
        LiczbaZespolona liczba2 = new LiczbaZespolona(1.0, 2.0);

        LiczbaZespolona suma = liczba1.dodaj(liczba2);
        LiczbaZespolona roznica = liczba1.odejmij(liczba2);
        LiczbaZespolona iloczyn = liczba1.pomnoz(liczba2);
        LiczbaZespolona iloraz = liczba1.podziel(liczba2);

        System.out.println("Suma: " + suma);
        System.out.println("Różnica: " + roznica);
        System.out.println("Iloczyn: " + iloczyn);
        System.out.println("Iloraz: " + iloraz);


        Wektor wektor1 = new Wektor(-3, 5, 3);
        Wektor wektor2 = new Wektor(4.0, 5.0, 6.0);


        Wektor sumaWektorow = wektor1.dodaj(wektor2);
        Wektor iloczynWektorowy = wektor1.iloczynWektorowy(wektor2);
        Wektor wektorSkal = wektor1.iloczynSkalarny(wektor2);
        double dlugoscWektora1 = wektor1.dlugosc();
        double dlugoscWektorSkal = wektorSkal.dlugosc();

        System.out.println("Suma: " + sumaWektorow);
        System.out.println("Iloczyn wektorowy: " + iloczynWektorowy);
        System.out.println("Iloczyn skalarny: " + wektorSkal + " dlugosc " + dlugoscWektorSkal);
        System.out.println("Długość wektora 1: " + dlugoscWektora1);

        //Wielomiany

        WielomianKwadratowy wielomian1 = new WielomianKwadratowy(1, -3, 2);
        WielomianKwadratowy wielomian2 = new WielomianKwadratowy(1, 2, 1);

        WielomianKwadratowy sumaWielo = wielomian1.dodaj(wielomian2);
        WielomianKwadratowy roznicaWielo = wielomian1.roznica(wielomian2);

        int[] poly1 = {1, 2, 3};  // 1 + 2x + 3x^2
        int[] poly2 = {4, 5};     // 4 + 5x

        int[] result = WielomianKwadratowy.mnozenieW(poly1, poly2);

        System.out.print("Wynik: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print("x^" + i + " + ");
            }


            double[] miejscaZerowe = wielomian1.miejscaZerowe();

            System.out.println("Suma: " + sumaWielo.a + "x^2 + " + sumaWielo.b + "x + " + sumaWielo.c);
            System.out.println("Różnica: " + roznicaWielo.a + "x^2 + " + roznicaWielo.b + "x + " + roznicaWielo.c);


            if (miejscaZerowe.length == 0) {
                System.out.println("Brak miejsc zerowych.");
            } else if (miejscaZerowe.length == 1) {
                System.out.println("Miejsce zerowe: x = " + miejscaZerowe[0]);
            } else {
                System.out.println("Miejsca zerowe: x1 = " + miejscaZerowe[0] + ", x2 = " + miejscaZerowe[1]);

            }
        }
    }
}
