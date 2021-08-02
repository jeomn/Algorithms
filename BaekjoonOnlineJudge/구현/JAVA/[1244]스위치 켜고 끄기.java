package com.trial;

import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		int switchNum = scan.nextInt();
		int[] switches = new int[switchNum+1];
		for(int i=1; i<=switchNum; i++) {
			switches[i] = scan.nextInt();
		}
		
		int students = scan.nextInt();
		for(int s=0; s<students; s++) {
			int sex = scan.nextInt();
			int num = scan.nextInt();
			
			if(sex == 1) {
				for(int i=num; i<=switchNum; i+=num) {
					switches[i] = (switches[i] == 1) ? 0 : 1;
				}
			}else {
				int i = 1;
				switches[num] = (switches[num] == 1) ? 0 : 1;
				while(0<num-i && num+i<=switchNum) {
					if(switches[num-i] != switches[num+i])
						break;
					
					switches[num-i] = (switches[num-i] == 1) ? 0 : 1;
					switches[num+i] = (switches[num+i] == 1) ? 0 : 1;
					i++;
				}
			}
		}
		for(int i=1; i<=switchNum; i++) {
			System.out.print(switches[i]+" ");
			if(i>=20 && i%20==0)
				System.out.println();
		}
		scan.close();
	}
}
