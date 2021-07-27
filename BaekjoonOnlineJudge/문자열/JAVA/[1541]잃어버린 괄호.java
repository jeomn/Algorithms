package com.trial;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int result = 0;
		boolean flag = true;
		String[] inputNum = scan.nextLine().split("\\-");
		for(String iNum:inputNum) {
			String[] nums = iNum.split("\\+");
			int sum = 0;
			for(String num: nums) {
				int n = Integer.valueOf(num);
				sum+=n;
			}
			if(flag) {
				result += sum;
				flag = false;
			}else
				result -= sum;
		}
		
		System.out.println(result);
		
	}
