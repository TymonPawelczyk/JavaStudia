public class Program {
    public static void main(String[] args) {
        Prostokat obj;
        obj = new Prostokat(3, 4);
        double x = obj.pole();
        double obw = obj.obwod();

        System.out.println("Pole prostokata: " + x + " Obwód prostokata: " + obw);


        Punkt obj1;
        obj1 = new Punkt(-1, 1);
        System.out.println("punkt: " + obj1);

        Prostokat obj2;
        obj2 = new Prostokat(3, 4, obj1);
        System.out.println("prostokat: " + obj2);

        double p = obj2.pole();
        System.out.println("pole: " + p);

        Punkt obj4;
        obj4 = new Punkt(5,5);
        System.out.println(obj4);

        obj4.przesun(-10,5);
        System.out.println(obj4);

        System.out.println("Przed przesunieciem: "+obj2.wierzcholek);
        obj2.przesun(3,3);
        System.out.println("Po przesunięciu: "+obj2.wierzcholek);

        Punkt obj5;
        obj5 = new Punkt(5,50);
        Okrag obj6;
        obj6 = new Okrag(3, obj5);
        System.out.println(obj6);
    }
}