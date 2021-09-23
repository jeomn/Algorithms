import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
     
    static int N, minCost = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] route;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
 
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
         
        route = new boolean[N];
        route[0] = true;
        goDelivery(1, 0, 0);
         
        System.out.println(minCost);
    }
     
 
    private static void goDelivery(int cnt, int node, int cost) {
        if(cost > minCost) return;
        if(cnt == N) {
            if(map[node][0] == 0) return;
            minCost = Math.min(minCost, cost+map[node][0]);
            return;
        }
         
        for(int i=1; i<N; i++) {
            if(route[i] || map[node][i]==0) continue;
            route[i] = true;
            goDelivery(cnt+1, i, cost+map[node][i]);
             
            route[i] = false;
        }
    }
}
