import java.awt.*;

public class Program
{
    public static void main(String[] args)
    {
        Rectangle obj=new Rectangle(0,0,4,3);

        obj.translate(1,-1);
        Rectangle obj1 = new Rectangle(0,0,4,3);
        Rectangle obj2 = new Rectangle(1,1,4,3);

        Rectangle obj4 = new Rectangle(1,1,4,5);
        Rectangle obj5 = new Rectangle(2,0,2,3);


//3.1
        double pole = obj.getHeight()*obj.getWidth();
        boolean test = obj.isEmpty();
//3.2
        Rectangle obj3 = obj1.intersection(obj2);
        double czescWspolna = obj3.getHeight()*obj3.getWidth();
//3.3
        boolean zawiera = obj4.intersects(obj5);
//3.4
        Point puknt = new Point(2,-1);
        Rectangle obj6 = new Rectangle(-3,0,6,3);
        boolean punktZawiera = obj6.contains(puknt);

//3.5
        Rectangle obj7 = new Rectangle(1,1,4,5);
        Rectangle obj8 = new Rectangle(4,-3,4,3);
        boolean czyPrzecina = obj7.intersects(obj8);

        System.out.println(obj);
        System.out.println(obj3);
        System.out.println("Pole prostokata: "+ pole);
        System.out.println("Cześć wspólna: "+ czescWspolna);
        System.out.println("Prostokaty zawierają się w sobie: "+ zawiera );
        System.out.println("Punkt zawiera się w prostokacie: "+ punktZawiera );
        System.out.println("Prostokat przecina sie z innym: "+ czyPrzecina);
    }
}
