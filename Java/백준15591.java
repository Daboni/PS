import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준15591 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] adj = new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;i++) {
			String s = br.readLine();
			String[] tmp = s.split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			int c = Integer.parseInt(tmp[2]);
			
			adj[a].add(new int[] {b,c});
			adj[b].add(new int[] {a,c});
			
		}
		
		for(int i=0;i<m;i++) {
			String s = br.readLine();
			String[] tmp = s.split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			
			boolean[] d = new boolean[n+1];
			d[y] = true;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(y);
			
			int ans=0;
			while(!q.isEmpty()) {
				
				int nx = q.poll();
				
				for(int[] a : adj[nx]) {
					if(d[a[0]]==true) continue;
					if(a[1]<x) continue;
					
					d[a[0]] = true;
					q.add(a[0]);
					ans++;
				}
			}
			System.out.println(ans);
			
		}
		
	}
}
