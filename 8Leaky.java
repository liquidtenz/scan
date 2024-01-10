import java.util.*;

class Leaky {

    public static void main(String[] args) {    
        
        Scanner sc = new Scanner(System.in);
        int no_of_queries = 4;
        int output_rate = 1;
        int input_packset_size = 0;
        int stored_size = 0;
        int bucket_size = 10;
        int size_left = 0;

       for(int i = 0 ; i < no_of_queries; i++){
            
            input_packset_size = sc.nextInt();
            size_left = bucket_size - stored_size;

            if(input_packset_size <= size_left) {
                stored_size += input_packset_size;
            }
            else 
            {
                System.out.println("Packet Dropped");
            }

            System.out.println("Stored Buffer Size: " + stored_size);
            stored_size -= output_rate;

       }
       
    }

}