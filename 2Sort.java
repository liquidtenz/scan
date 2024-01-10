import java.util.*;

class Sort {

    public static void main(String[] args) {

        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        List<int[]> frames = new ArrayList<>();

        System.out.println("Enter the number of packets");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            System.out.println("Enter the data from frame " + (i + 1));
            frames.add(new int[]{r.nextInt(20000), sc.nextInt()});
        }

        System.out.println("Before Sorting");
        System.out.println("Seq\tData");
        for(int[] frame: frames) {
            System.out.printf("%d\t%d\n", frame[0], frame[1]);
        }

        Collections.sort(frames, (a,b)-> Integer.compare(a[0],b[0]));
        
        System.out.println("After Sorting");
        System.out.println("Seq\tData");
        for(int[] frame: frames) {
            System.out.printf("%d\t%d\n", frame[0], frame[1]);
        }
    }
}