public class Program
{
    public static void main(String[] args)
    {
        Dokument[] bazaDanych={new Paszport(),new DowodOsobisty(),new Paszport()};

        Dokument z;
        String wzorzec="Gorniak";

        for(int i=0;i<bazaDanych.length;i++)
        {
            z=bazaDanych[i];
            if(z.czyPasuje(wzorzec))System.out.println("znaleziono: "+z);
        }
    }
}
