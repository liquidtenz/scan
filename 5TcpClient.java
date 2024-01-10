import java.util.*;
import java.net.*;
import java.io.*;

class TcpClient {

    public static void main(String[] args) throws Exception{

        Socket sock = new Socket("localhost", 3000);

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the file name: ");
        String filename = sc.nextLine();

        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwriter = new PrintWriter(ostream, true);

        pwriter.println(filename);

        InputStream istream = sock.getInputStream();
        BufferedReader content = new BufferedReader(new InputStreamReader(istream));

        String str;

        while((str = content.readLine()) != null) {
            System.out.println(str);
        }

        content.close();
        pwriter.close();
        sock.close();
    }
}