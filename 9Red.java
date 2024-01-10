import java.util.*;

class Red { 

    public static void main(String[] args) {

        int max_packet = 20;
        int queue_size = 10;
        int queue_len = 0;
        double min_prob = 0.3;
        double max_prob = 0.7;
        double curr_prob = min_prob;

        Random rd = new Random();

        for(int i = 0; i < max_packet; i++) {

            if(queue_len == queue_size) {
                System.out.println("Packet Dropped (Queue Full)");
                curr_prob = min_prob;
            }
            else if((double)rd.nextDouble() < curr_prob) {
                System.out.println("Packet Dropped (Random)");
                curr_prob += (max_prob-min_prob)/(max_packet-1);
            }
            else {
                System.out.println("Packet Accepted");
                queue_len++;
                curr_prob = min_prob;
            }
        }

    }

}