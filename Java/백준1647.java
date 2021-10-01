import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class 백준1647 {

	public static class Vertex implements Comparable<Vertex>{
		int no;
		int cost;
		public Vertex(int no,int cost) {
			this.no = no;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Vertex>[] adjList = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		int[] minEdge = new int[n+1];
		boolean[] visited = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[start].add(new Vertex(end,cost));
			adjList[end].add(new Vertex(start,cost));
		}
		
		Arrays.fill(minEdge,Integer.MAX_VALUE);
		
		minEdge[1] = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		pq.offer(new Vertex(1,0));
		
		int max = -1;
		int result = 0; int cnt = 0;
		while(!pq.isEmpty()) {
			
			Vertex minVertex = pq.poll();
			if(visited[minVertex.no]) continue;
			
			visited[minVertex.no] = true;
			result += minVertex.cost;
			
			if(max<minVertex.cost) max = minVertex.cost;
			
			if(++cnt == n) break;
			
			for(Vertex v : adjList[minVertex.no]) {
				if(!visited[v.no] && minEdge[v.no]>v.cost) {
					minEdge[v.no] = v.cost;
					pq.offer(new Vertex(v.no,v.cost));
				}
			}
//			
//			for(int i=1;i<=n;i++) {
//				if(!visited[i] && adjMatrix[minVertex.no][i] != 0 && minEdge[i]>adjMatrix[minVertex.no][i]) {
//					minEdge[i] = adjMatrix[minVertex.no][i];
//					pq.offer(new Vertex(i,adjMatrix[minVertex.no][i]));
//				}
//			}
			
		}
		System.out.println(result-max);
	}
}
