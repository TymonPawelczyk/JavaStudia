import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class Odbior extends Thread
{
    Socket sock;
    BufferedReader sockReader;

    public Odbior(Socket sock) throws IOException
    {
        this.sock=sock;
        this.sockReader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }
    public void run() {
        try {
            String message;
            while ((message = sockReader.readLine()) != null) {
                System.out.println("\n<Received:> " + message);
                System.out.print("<Send:> ");
                if (message.equalsIgnoreCase("koniec")) {
                    System.out.println("Koniec połączenia");
                    break;
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
        } finally {
            try {
                sockReader.close();
                sock.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }
}