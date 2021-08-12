import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	static int[] dwarf, dwarfTemp, myDwarf;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarf = new int[9];
		
		for(int i=0; i<9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		myDwarf = new int[7];
		dwarfTemp = new int[7];
		findDwarf(0, 0, 0);
		
		for(int i=0; i<7; i++) {
		System.out.println(myDwarf[i]);
		}
	}

	
	private static void findDwarf(int cnt, int idx, int sum) {
		if(sum > 100) return;
		if(cnt==7 && sum == 100) {
			myDwarf = dwarfTemp.clone();
		}
		if(cnt==7) return;
		
		for(int i=idx; i<9; i++) {
			dwarfTemp[cnt] = dwarf[i];
			findDwarf(cnt+1, i+1, sum+dwarf[i]);
		}
	}	
}
