/*
LinkedList는 앞에서부터 탐색하니까 0(N)
>>ListIterator로 O(1) 접근이 가능

프린트 n번보단
SB로 N개 합쳐서 출력 한 번 하는게 더 빠름
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;


public class Main {

	public static void main(String[] args) throws IOException {
    //scanner써도 통과함.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for(int t=0; t<test; t++) {
			String input = br.readLine();
			
			LinkedList<Character> password = new LinkedList<>();
			ListIterator<Character> lidx = password.listIterator();
			
			for(int i=0; i<input.length(); i++) {
				char c = input.charAt(i);
				
        //if문 switch문의 경우 3~4개 이상은 switch가 더 빠른 듯. 이 문제에서는 if가 더 빨랐음
				switch(c) {
					case '<':
						if(lidx.hasPrevious())
							lidx.previous();
						break;
						
					case '>':
						if(lidx.hasNext())
							lidx.next();
						break;
						
					case '-':
						if(lidx.hasPrevious()) {
							lidx.previous();
							lidx.remove();
						}
						break;
						
					default:
						lidx.add(c);
				}
			}
      //프린트 n번 보다, sb로 n개 문자열 더해서 한 번 출력하는 게 더 빠름
			StringBuilder sb = new StringBuilder();
			for(char p: password)
				sb.append(p);
			System.out.println(sb);	
		}
	}
}
