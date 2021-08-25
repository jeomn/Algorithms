import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = input.length();
		
		int cnt = N, i = 0;
		while(true) {
			if(i>=N) break;
			char s = input.charAt(i);
			if(i == N-1) {
				break;
			}
			char temp = input.charAt(i+1);
			if(s == 'c') {
				if(temp == '=') {
					cnt--;
					i++;
				}else if(temp == '-') {
					cnt--;
					i++;
				}
			}else if(s == 'd') {
				if(temp == '-') {
					cnt--;
					i++;
				}else if(i<N-2) {
					char temp2 = input.charAt(i+2);
					if(temp == 'z' && temp2 == '=') {
						cnt-=2;
						i+=2;
					}
				}
			}else if(s == 'l') {
				if(temp == 'j') {
					cnt--;
					i++;
				}
			}else if(s == 'n') {
				if(temp == 'j') {
					cnt--;
					i++;
				}
			}else if(s == 's') {
				if(temp == '=') {
					cnt--;
					i++;
				}
			}else if(s == 'z') {
				if(temp == '=') {
					cnt--;
					i++;
				}
			}
			i++;
		}

		System.out.println(cnt);
	}
}
