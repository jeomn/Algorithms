//스택

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		
		Stack<Character> string = new Stack<>();
		boolean isTag = false, isAlpabet = false;
		for(int idx=0; idx<input.length(); idx++) {
			char s = input.charAt(idx);
			if(s == '<') {
				isTag = true;
				while(!string.isEmpty()) {
					sb.append(string.pop());
				}
			}

			if(isTag) {
				sb.append(s);
			}else if(s == ' ') {
				while(!string.isEmpty()) {
					sb.append(string.pop());
				}
				sb.append(s);
			}else {
				string.add(s);
			}
			
			if(s=='>') isTag = false;
		}
		while(!string.isEmpty()) {
			sb.append(string.pop());
		}
		System.out.println(sb);
	}
}
