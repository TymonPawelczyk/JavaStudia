import java.io.*;
public class Program {
    public static void main(String[] args) {
        System.out.println("-- do zapisu --");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Wybierz dokument:");
        System.out.println("1 - dowod osobisty");
        System.out.println("2 - paszport");
        BufferedReader wybor = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("input a number");
        int n = 0;
        try {
            n = Integer.parseInt(wybor.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        switch (n) {
            case 1:
                DowodOsobisty z = new DowodOsobisty(br);
                z.info();
                try {
                    ObjectOutputStream outp = new ObjectOutputStream(new FileOutputStream("plik.dat"));
                    outp.writeObject(z);
                    outp.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Błąd: Nie można otworzyć pliku. Sprawdź nazwę pliku.");
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 2:
                Paszport y = new Paszport(br);
                y.info();
                try {
                    ObjectOutputStream outp = new ObjectOutputStream(new FileOutputStream("plik.dat"));
                    outp.writeObject(y);
                    outp.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Błąd: Nie można otworzyć pliku. Sprawdź nazwę pliku.");
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
        }






        System.out.println("\n-- z pliku --");
        ObjectInputStream inp;

        try {
            inp = new ObjectInputStream(new FileInputStream("plik.dat"));
            Object o = inp.readObject();
            DowodOsobisty x = (DowodOsobisty) o;
            inp.close();
            x.info();
        } catch (FileNotFoundException e) {
            System.out.println("Błąd: Nie można otworzyć pliku do odczytu. Sprawdź nazwę pliku.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}