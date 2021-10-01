import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 백준17471 {
	
	public static int n;
	public static ArrayList<ArrayList<Integer>> map;
	public static int[] population;
	public static boolean[] d;
	public static Queue<Integer> q;
	public static int ans;
	
	public static int[] team;
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		population = new int[n];
		
		for(int i=0;i<n;i++) {
			population[i] = sc.nextInt();
		}
		
		map = new ArrayList<>();
		ans = 987654321;

		for(int i=0;i<n;i++) {
			map.add(new ArrayList<Integer>());			
		}
		
		for(int i=0;i<n;i++) {
			
			int num = sc.nextInt();
			for(int j=0;j<num;j++) {
				int des = sc.nextInt()-1;
				map.get(i).add(des);
				map.get(des).add(i);
			}
		}
		team = new int[n];
		go(0,team);
		
		System.out.println(ans==987654321?-1:ans);
	}
	
	public static void go(int idx,int[] team) {
		
		if(idx==n) {
			if(bfs()) {
				int popA=0;
				int popB=0;
				for(int i=0;i<n;i++) {
					if(team[i]==1) {
						popA+=population[i];
					}
					else if(team[i]==2) {
						popB+=population[i];
					}
				}
				if(ans>(Math.abs(popA-popB))) ans = Math.abs(popA-popB);
			}
			return;
		}
		team[idx]=1;
		go(idx+1,team);
		team[idx]=2;
		go(idx+1,team);
		
	}
	
	public static boolean bfs() {
		
		d = new boolean[n];
		q = new LinkedList<>();

		for(int i=0;i<n;i++) {
			if(team[i]==1) {
				q.add(i);
				d[i] = true;
				break;
			}
		}

		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int i : map.get(x)) {
				
				if(!d[i]) {
					if(team[i]==1) {
						q.add(i);
						d[i]=true;
					}
				}
				
			}	
		}
		for(int i=0;i<n;i++) {
			if((team[i]==1 && !d[i]) || (team[i]==2 && d[i])) return false;
		}
		
		d = new boolean[n];
		q = new LinkedList<>();

		for(int i=0;i<n;i++) {
			if(team[i]==2) {
				q.add(i);
				d[i] = true;
				break;
			}
		}

		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int i : map.get(x)) {
				
				if(!d[i]) {
					if(team[i]==2) {
						q.add(i);
						d[i]=true;
					}
				}
				
			}	
		}
		for(int i=0;i<n;i++) {
			if((team[i]==2 && !d[i]) || (team[i]==1 && d[i])) return false;
		}
		return true;
	}
}
