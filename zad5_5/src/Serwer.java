import java.io.*;
import java.net.*;

public class Serwer {
    public static final int PORT = 50007;

    public static void main(String args[]) throws IOException {
        try {

            ServerSocket serv = new ServerSocket(PORT);

            System.out.println("Listening: " + serv);
            Socket sock = serv.accept();
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

                if (message.equalsIgnoreCase("koniec") || sock.isClosed()) {
                    break;
                }
            }

            sockWriter.close();
            sock.close();
            serv.close();

        }catch(ConnectException e){
            System.out.println("Polaczenie zostalo przerwane");
        }catch (SocketException d){
            System.out.println("zly socket");
        }

    }
}
