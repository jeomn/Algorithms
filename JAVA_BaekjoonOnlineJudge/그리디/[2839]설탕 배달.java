package com.ssafy.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int minCnt = 0;
		while(true) {
			if(N < 0) {
				minCnt = -1;
				break;
			}
			
			if(N%5 == 0) {
				minCnt += N/5;
				break;
			} else {
				N -= 3;
				minCnt++;
			}
		}
		
		System.out.println(minCnt);
	}
}
