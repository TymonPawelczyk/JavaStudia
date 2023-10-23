import java.io.*;

public class Protokat {
    public static void main(String[] args){

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Podaj szerokość prostokąta: ");
            Double szerokosc= Double.valueOf(br.readLine());
            System.out.println("Podaj wysokość prostokąta: ");
            Double wysokosc = Double.valueOf(br.readLine());

            double pole = szerokosc * wysokosc;

            PrintWriter plik1=new PrintWriter(new BufferedWriter(new FileWriter("plik.txt",true)));
            plik1.println("Pole prostokąta wynosi: "+ pole);
            plik1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}

