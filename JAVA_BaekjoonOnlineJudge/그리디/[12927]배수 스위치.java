import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] lamp = br.readLine().toCharArray();
		int cnt = 0;
		for(int i=1; i<=lamp.length; i++) {
			if(lamp[i-1] == 'Y') {
				cnt++;
				for(int j=i; j<=lamp.length; j+=i) {
					lamp[j-1] = (lamp[j-1]=='Y')? 'N':'Y';
				}
			}
		}
		System.out.println(cnt);
	}
}
