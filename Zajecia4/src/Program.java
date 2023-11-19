public class Program
{
    public static void main(String[] args)
    {
        System.out.println("-- do zapisu --");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        DowodOsobisty z=new DowodOsobisty(br);
        z.info();

        try
        {
            ObjectOutputStream outp=new ObjectOutputStream(new FileOutputStream("plik.dat"));
            outp.writeObject(z);
            outp.close();
        }
        catch(Exception e){System.out.println(e);}



        System.out.println("\n-- z pliku --");
        ObjectInputStream inp;

        try
        {
            inp=new ObjectInputStream(new FileInputStream("plik.dat"));
            Object o=inp.readObject();
            DowodOsobisty x=(DowodOsobisty)o;
            inp.close();
            x.info();
        }
        catch(Exception e){System.out.println(e);}
    }
}