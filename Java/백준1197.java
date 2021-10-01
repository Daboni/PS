import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1197 {	
	
	public static int V;
	public static int E;
	public static int[] parents;
	public static Edge[] edgeList;
	
	public static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(start,end,cost);
		}
		
		Arrays.sort(edgeList);
		make();
		
		int cost =0; int cnt=0;	
		for(Edge edge : edgeList) {
			if(union(edge.start, edge.end)) {
				cost += edge.cost;
				if(++cnt == V-1) break;
			}
		}
		System.out.println(cost);
	}
	
	public static void make() {
		parents = new int[V+1];
		for(int i=1;i<=V;i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a,int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		parents[pa] = pb;
		return true;
	}
}
