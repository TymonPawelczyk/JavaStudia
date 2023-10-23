import java.io.*;
public class A
{
    static double KURS_DOLAR=4.2;
    static double KURS_EURO=0.94;
    static double KURS_CZK = 23.23;

    public static void main(String[] args)
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader wybor = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("$: ");
            String str=br.readLine();
            System.out.println("Wybierz na jaka walute chcesz przeliczyć podajac cyfre: ");
            System.out.println("1 - PLN");
            System.out.println("2 - EURO");
            System.out.println("3 - Korona czeska");

            Integer integer = Integer.valueOf(wybor.readLine());
            double x = Double.parseDouble(str);
            if (integer == 1){
                System.out.println("PLN: "+x*KURS_DOLAR);
            } else if (integer == 2) {
                System.out.println("EURO " + x * KURS_EURO);
            } else if (integer == 3) {
                System.out.println("Korona czeska: " + x * KURS_CZK);
            }


        }

        catch(IOException e1)
        {
            System.out.println("wyjatek operacji wejscia/wyjscia");
        }

        catch(NumberFormatException e2)
        {
            System.out.println("nieprawidlowy format liczby");
        }
    }
}