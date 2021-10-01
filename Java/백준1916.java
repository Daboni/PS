import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class 백준1916 {
	
	public static class Edge implements Comparable<Edge>{
		int no;
		int cost;
		public Edge(int no,int cost) {
			this.no = no;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.no, o.no);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		Set<Edge>[] adjList = new HashSet[V+1];
		
		for(int i=1;i<=V;i++) {
			adjList[i] = new HashSet();
		}
		StringTokenizer st;
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjList[start].add(new Edge(end,cost));
			
		}
		st = new StringTokenizer(br.readLine());
		int startNode = Integer.parseInt(st.nextToken());
		int endNode = Integer.parseInt(st.nextToken());
				
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
//		boolean[] visited = new boolean[V+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		dist[startNode] = 0;
		pq.add(new Edge(startNode,0));
		
		while(!pq.isEmpty()) {
			
			Edge edge = pq.poll();
			
			if(dist[edge.no] < edge.cost) continue;
			
//			if(edge.no == endNode) break;
			
			for(Edge next : adjList[edge.no]) {
				if(dist[next.no] > dist[edge.no]+next.cost) {
					dist[next.no] = dist[edge.no] + next.cost;
					pq.add(new Edge(next.no,dist[next.no]));
				}
			}
			
		}
		System.out.println(dist[endNode]);
	}
}
