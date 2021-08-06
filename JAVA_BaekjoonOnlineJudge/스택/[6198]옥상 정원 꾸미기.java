/*
자료형... long은 int보다 큰 정수, double은 실수

ArrayList<Integer> input = new ArrayList<>();
  //데이터 처리
Stack<Integer> buildings = new Stack<>();
Collections.reverse(input);     //List 뒤집기
buildings.addAll(input);        //List 통으로 stack 넣기
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Stack<Double> buildings = new Stack<>();
		buildings.add(Double.valueOf(br.readLine()));

		long count = 0;
		for(int i=0; i<N-1; i++) {
			double building = Double.valueOf(br.readLine());
			while(!buildings.isEmpty()) {
				if(buildings.peek() <= building) {
					buildings.pop();
				}else
					break;
			}
			buildings.add(building);
			count += buildings.size()-1;
		}
		
		System.out.println(count);
	}	
}
