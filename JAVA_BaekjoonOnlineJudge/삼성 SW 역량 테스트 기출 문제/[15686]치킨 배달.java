import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_15686_ChickenDelivery {
	
	static int M, minDistance;
	static int[] isChicken;
	static HashMap<Integer, int[]> house, chicken;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new HashMap<>();
		chicken = new HashMap<>();
		int hNum = 0, cNum = 0;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(temp==1) {
					house.put(hNum++, new int[] {r, c});
				}else if(temp==2) {
					chicken.put(cNum++, new int[] {r, c});
				}
			}
		}
		
		isChicken = new int[M];
		minDistance = Integer.MAX_VALUE;
		findChickenDistance(0, 0);
		
		System.out.println(minDistance);
	}

	private static void findChickenDistance(int cnt, int idx) {
		if(cnt==M) {
			
			
			int sumDistance = 0;
			for(int i=0; i<house.size(); i++) {
				int[] h = house.get(i);
				
				int minTemp = Integer.MAX_VALUE;
				for(int j=0; j<M; j++) {
					int[] c = chicken.get(isChicken[j]);
					int d = Math.abs(c[0]-h[0]) + Math.abs(c[1]-h[1]);
					minTemp = Math.min(minTemp, d);
				}
				sumDistance += minTemp;
			}
			minDistance = Math.min(minDistance, sumDistance);
			return;
		}
		
		for(int i=idx; i<chicken.size(); i++) {
			isChicken[cnt] = i;
			findChickenDistance(cnt+1, i+1);
    		}
	}
}


/*******************
* 20211008
*******************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M, tempM, minDistance = Integer.MAX_VALUE;
	static int[][] city;
	static Node[] myChicken;
	static ArrayList<Node> chickenList, houseList;
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		city = new int[N][N];
		chickenList = new ArrayList<>();
		houseList = new ArrayList<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				city[r][c] = Integer.parseInt(st.nextToken());
				if(city[r][c] == 1) houseList.add(new Node(r, c));
				else if(city[r][c] == 2) chickenList.add(new Node(r, c));
			}
		}
		
		for(int m=1; m<=M; m++) {
			tempM = m;
			myChicken = new Node[m];
			setChicken(0, 0);
		}
		
		System.out.println(minDistance);
	}

	private static void setChicken(int cnt, int idx) {
		if(cnt == tempM) {
			minDistance = Math.min(minDistance, getChickenDistance());
			return;
		}
		if(idx == chickenList.size()) return;
		
		myChicken[cnt] = chickenList.get(idx);
		setChicken(cnt+1, idx+1);
		myChicken[cnt] = null;
		setChicken(cnt, idx+1);
	}

	private static int getChickenDistance() {
		int sumD = 0;
		for(Node h : houseList) {
			int d = Integer.MAX_VALUE;
			for(Node c : myChicken) {
				d = Math.min(d, (Math.abs(c.x-h.x) + Math.abs(c.y-h.y)));
			}
			sumD += d;
		}
		return sumD;
	}
}
