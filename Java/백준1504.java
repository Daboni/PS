import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준1504 {
	
	public static class Edge implements Comparable<Edge>{
		
		int no;
		int cost;
		
		public Edge(int no,int cost) {
			this.no = no;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static int n;
	public static int m;
	
	public static int pass1;
	public static int pass2;
	public static List<Edge>[] adjList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjList[start].add(new Edge(end,cost));
			adjList[end].add(new Edge(start,cost));
		}
		st = new StringTokenizer(br.readLine());
		
		pass1 = Integer.parseInt(st.nextToken());
		pass2 = Integer.parseInt(st.nextToken());
		
		long ans = dijkstra(1,pass1) + dijkstra(pass1,pass2) + dijkstra(pass2,n);
		
		long ans2 = dijkstra(1,pass2) + dijkstra(pass2,pass1) + dijkstra(pass1,n);
		
		System.out.println(Math.min(ans,ans2)>=987654321 ? -1 : Math.min(ans,ans2));
		
	}
	public static long dijkstra(int start,int end) {
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		int dist[] = new int[n+1];
		Arrays.fill(dist,987654321);
		dist[start] = 0;
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			
			Edge edge = pq.poll();
			
			if(dist[edge.no]<edge.cost) continue;
			
			for(Edge next : adjList[edge.no]) {
				
				if(dist[next.no] > dist[edge.no]+next.cost) {
					dist[next.no] = dist[edge.no]+next.cost;
					pq.add(new Edge(next.no,dist[next.no]));
				}
				
			}
			
		}
		return dist[end];
	}
}
