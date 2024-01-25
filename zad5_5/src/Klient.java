import java.io.*;
import java.net.*;

public class Klient {
    public static final int PORT = 50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        try {

            Socket sock = new Socket(HOST, PORT);
            System.out.println("Connection established: " + sock);

            // Otworzenie watku odbioru
            Odbior receiverThread = new Odbior(sock);
            receiverThread.start();

            PrintWriter sockWriter = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("<Send:> ");
                String message = keyboard.readLine();
                sockWriter.println(message);


                if (message.equalsIgnoreCase("koniec")  || sock.isClosed()) {
                    break;
                }
            }
            
            sockWriter.close();
            sock.close();
        }catch(ConnectException e){
            System.out.println("Polaczenie zostalo przerwane");
        }catch (SocketException d){
            System.out.println("Bledny socket");
        }
    }
}