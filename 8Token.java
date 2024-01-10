import java.util.*;
import java.math.*;

class Token {
    
    public static void main(String[] args) {

        int token = 0;
        int rate = 10;
        int capacity  = 100;

        int [] request = new int[100];

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of request");
        int n = sc.nextInt();

        System.out.println("Enter the number of packets per request");
        for(int i = 0; i < n; i++){
            request[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {

            token = Math.min(token+rate, capacity);
            System.out.println("Number of Packets: " + request[i]);

            if(token >= request[i]) {
                token -= request[i];
                System.out.println("Request Granted tokens remaning " + token);
            }
            else 
            {
                System.out.println("Request Denied not enought token " + token);
            }

        }

    }

}