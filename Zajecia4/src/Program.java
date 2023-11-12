public class Program
{
    public static void main(String[] args)
    {

        Prostokat a=new Prostokat(3,4);
        a.info();

        Prostokat b=new Prostokat(2,2);
        b.info();



        if(a.intersects(b))
        {
            System.out.println("-- przecinaja sie --\n");
        }
        else
        {
            System.out.println("-- NIE przecinaja sie --\n");
        }



        a.translate(5,3);
        a.info();

        if(a.intersects(b))
        {
            System.out.println("-- przecinaja sie --\n");
        }
        else
        {
            System.out.println("-- NIE przecinaja sie --\n");
        }

    }
}