import java.util.*;

class Bell {

    static int n;
    static int[][] graph = new int[100][100];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the source vertex: ");
        int s = sc.nextInt();

        bellman(s-1);
    }

    public static void bellman(int s) {

        int[] dist = new int[100];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        for(int i = 0; i < n; i++) {
            for(int u = 0; u < n; u++) {
                for(int v = 0; v < n; v++) {
                    if(graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && graph[u][v]+dist[u] < dist[v]){
                        dist[v] = dist[u]+graph[u][v];
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int u = 0; u < n; u++) {
                for(int v = 0; v < n; v++) {
                    if(graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && graph[u][v]+dist[u] < dist[v]){
                        System.out.println("Negative Weigth cycle detected");
                        return;
                    }
                }
            }
        }

        printResult(dist);
    }

    public static void printResult(int[] dist) {

        System.out.println("Distance from Source");

        for(int i = 0; i < n; i++) {
            System.out.printf("%d--->%d\n", i+1, dist[i]);
        }

    }

}