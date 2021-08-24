package com.ssafy.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_7465_ChangYongTownNetwork {
	
	static int N, M;
	static int[] parents, level;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N];
			level = new int[N];
			for(int i=0; i<N; i++) {
				parents[i] = i;
				level[i] = 1;
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				union(a, b);
			}
			
			Set<Integer> roots = new HashSet<>();
			for(int i=0; i<N; i++) {
				roots.add(find(i));
			}
			System.out.println("#"+test+" "+roots.size());
		}

	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return;
		if(level[rootA]<level[rootB]) {
			int temp = rootA;
			rootA = rootB;
			rootB = temp;
		}
		parents[rootB] = rootA;
		
		if(level[rootA] == level[rootB])
			level[rootA]++;
	}
}
