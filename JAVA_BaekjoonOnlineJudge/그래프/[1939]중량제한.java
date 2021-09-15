//20210915 스터디에서 시간을 좀 더 단축할 방법에 대해 들었다...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] path;
	static class Node implements Comparable<Node>{
		int n;
		int w;
		Node(int n, int w){
			this.n = n;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return o.w - this.w;
		}
	}

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to, weight));
			graph.get(to).add(new Node(from, weight));
		}
		
		for(int i=0; i<N; i++) {
			Collections.sort(graph.get(i));
		}
		
		st = new StringTokenizer(br.readLine());
		int factory1 = Integer.parseInt(st.nextToken())-1;
		int factory2 = Integer.parseInt(st.nextToken())-1;
		
		path = new int[N];
		/*
		findRoute(factory1);
		
		System.out.println(path[factory2]);
		*/
		int result = findRoute(factory1, factory2);
        	System.out.println(result);
	}
	
	//private static void findRoute(int start) {
	private static int findRoute(int start, int end) {
		PriorityQueue<Node> route = new PriorityQueue<>();
		route.add(new Node(start, 0));
		
		while(!route.isEmpty()) {
			Node node = route.poll();
			int weight = node.w;
			int num = node.n;
			
			if(num == end) return path[end];
			
			if(weight < path[num]) continue;
			
			for(Node adj: graph.get(num)) {
				if(weight == 0) {
					path[adj.n] = adj.w;
					route.add(new Node(adj.n, adj.w));
				}
				if(path[adj.n] < adj.w && path[adj.n] < weight) {
					path[adj.n] = Math.min(adj.w, weight);
					route.add(new Node(adj.n, path[adj.n]));
				}
			}
		}
		return 0;
	}
}
