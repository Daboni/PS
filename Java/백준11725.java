import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 백준11725 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Integer>[] adjList = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			adjList[i]=new ArrayList<Integer>(); 
		}
		for(int i=0;i<n-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] d = new boolean[n+1];
		int[] ans = new int[n+1];
		
		q.add(1);
		d[1]= true;
		
		while(!q.isEmpty()) {
			
			int p = q.poll();
			
			for(int i=0;i<adjList[p].size();i++) {
				if(d[adjList[p].get(i)]) continue;
				q.add(adjList[p].get(i));
				d[adjList[p].get(i)]=true;
				ans[adjList[p].get(i)] = p;
			}
		}
		
		for(int i=2;i<=n;i++) {
			System.out.println(ans[i]);
		}
	}
}
