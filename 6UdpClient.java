import java.util.*;
import java.io.*;
import java.net.*;

class UpdClient {

    public static void main(String[] args) throws Exception {

        DatagramSocket dsocket = new DatagramSocket(4000);
        DatagramPacket dpacket;

        byte[] buffer;

        while(true) {
            buffer = new byte[555];
            dpacket = new DatagramPacket(buffer, buffer.length);
            dsocket.receive(dpacket);
            String mes = new String(buffer).trim();

            System.out.println(mes);
            if(mes.equals("exit")) {
                dsocket.close();
                break;
            }
        }

    }

}