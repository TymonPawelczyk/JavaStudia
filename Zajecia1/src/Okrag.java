//Do Twojego projektu dodaj definicję klasy Okrag zawierającej pola promien i srodek (okręgu).
// Napisz implementacje odpowiednich konstruktorów oraz metod, podobnie jak w klasie Prostokat. Przetestuj przykład.
//Do klas Prostokat i Okrag dodaj implementacje metody boolean zawiera(Punkt obj).
// W programie, przetestuj na przykładzie kilku różnych prostokątów i punktów.
import static java.lang.Math.*;
class Okrag {
    double r;
//    promien
    Punkt s;
//    srodek
    Okrag(double r, Punkt s){
        this.r = r;
        this.s = new Punkt(s.x,s.y);
    }
    public String toString(){
        return "Promień "+r+" Srodek "+ s;
    }

    boolean zawiera(Punkt t){
        double x1 = t.x;
        double y1 = t.y;
//        d = Math.sqrt(s.x-x1)
////d=√((x_2-x_1)²+(y_2-y_1)²)
//        return True;
    }
}
