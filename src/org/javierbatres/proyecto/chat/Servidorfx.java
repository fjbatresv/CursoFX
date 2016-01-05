package org.javierbatres.proyecto.chat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidorfx {

    public static void main(String args[]) {
        String data = "Toobie ornaught toobie";
        try {
            ServerSocket srvr = new ServerSocket(12346);

            Socket skt = srvr.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            System.out.print("Server has connected!\n");
            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            System.out.print("Sending string: '" + data + "'\n");
            out.print(data);
     
            System.out.println(reader.ready());
            
           while(reader.readLine() != null) { //HERE :S please help
                System.out.println(reader.readLine());
            }
           
            out.close();
            skt.close();
            srvr.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Whoops! It didn't work!\n");
        }
    }
}