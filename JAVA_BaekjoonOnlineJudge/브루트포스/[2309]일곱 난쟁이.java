import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	
	static int[] dwarf;
	static int[] myDwarf;
    static boolean flag;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarf = new int[9];
		myDwarf = new int[7];
		for(int i=0; i<9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
        flag = false;
		findDwarf(0, 0, 0);
	}

	private static void findDwarf(int cnt, int idx, int sum) {
		if(sum > 100 || flag) return;
		if(cnt == 7) {
			if(sum == 100) {
				Arrays.sort(myDwarf);
				for(int i=0; i<7; i++) {
					System.out.println(myDwarf[i]);
				}
                flag = true;
			}
            return;
		}
		
		for(int i=idx; i<9; i++) {
			myDwarf[cnt] = dwarf[i];
			findDwarf(cnt+1, i+1, sum+dwarf[i]);
		}
	}
}
