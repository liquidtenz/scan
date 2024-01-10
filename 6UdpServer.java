import java.util.*;
import java.io.*;
import java.net.*;

class UdpServer {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        DatagramSocket dsocket = new DatagramSocket();
        DatagramPacket dpacket;

        InetAddress client = InetAddress.getByName("127.0.0.1");
        String message;
        byte[] buffer;


        while(true) {
            message = sc.nextLine();
            buffer = message.getBytes();
            dpacket = new DatagramPacket(buffer, buffer.length, client, 4000);
            dsocket.send(dpacket);

            if(message.equals("exit")) {
                dsocket.close();
                break;
            }
        }

    }

}