import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
         
        int T = Integer.parseInt(br.readLine());
        for(int test=1; test<=T; test++) {
             
            char[][] text = new char[5][];
            int maxNum = 0;
            for(int r=0; r<5; r++) {
                text[r] = br.readLine().toCharArray();
                maxNum = Math.max(maxNum, text[r].length);
            }
             
            sb = new StringBuilder();
            sb.append("#"+test+" ");
            for(int c=0; c<maxNum; c++) {
                for(int r=0; r<5; r++) {
                    try {
                        sb.append(text[r][c]);
                    } catch(ArrayIndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }
             
            System.out.println(sb);
        }
    }
}
