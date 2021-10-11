import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] origin = new String[8];
		Arrays.fill(origin, "0000");
		String input = br.readLine();
		String[] ipv6 = input.split(":");
		
		int len = 0, idx=0, oIdx=0;
		boolean flag = true;
		while(true) {
			if(len == ipv6.length) break;
			
			int num = ipv6[idx].length();
			if(num == 4) origin[oIdx] = ipv6[idx];
			else if(num == 3) origin[oIdx] = "0"+ipv6[idx];
			else if(num == 2) origin[oIdx] = "00"+ipv6[idx];
			else if(num == 1) origin[oIdx] = "000"+ipv6[idx];
			else {
				idx = ipv6.length;
				oIdx = 8;
				flag = false;
			}
			
			if(!flag) {
				idx-=1;
				oIdx-=1;
				len++;
			}else {
				idx+=1;
				oIdx+=1;
				len++;
			}
		}
		
		System.out.println(String.join(":", origin));
	}
}
