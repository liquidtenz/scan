import java.util.*;
import java.io.*;
import java.net.*;

class TcpServer {

    public static void main(String[] args) throws Exception {    

        ServerSocket serverSocket = new ServerSocket(3000);

        System.out.println("Server started and waiting for client");

        Socket sock = serverSocket.accept();

        System.out.println("Connected successfully waiting for filename");
        InputStream istream = sock.getInputStream();

        BufferedReader nameRead = new BufferedReader(new InputStreamReader(istream));
        String filename = nameRead.readLine();

        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwriter = new PrintWriter(ostream, true);

        try {
            
            BufferedReader content = new BufferedReader(new FileReader(filename));
            String str;

            while((str = content.readLine()) != null) {
                pwriter.println(str);
            }
            content.close();
        } catch(FileNotFoundException e) {
            pwriter.println("File not found");
        }
        finally {
            System.out.println("Closing connection");
            pwriter.close();
            nameRead.close();
            sock.close();
            serverSocket.close();
        }
    }

}