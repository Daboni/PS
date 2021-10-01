import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 백준1922 {
	
	public static int E;
	public static int V;
	public static int[] parents;
	public static Edge[] edgeList;
	
	public static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int cost;
		
		public Edge(int start,int end,int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		edgeList = new Edge[E];
		
		for(int i=0;i<E;i++) {
			String[] s = br.readLine().split(" "); 
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);
			
			edgeList[i] = new Edge(start,end,cost);
		}
		Arrays.sort(edgeList);
		make();
		int cnt=0; int cost =0;
		for(Edge edge : edgeList) {
			if(union(edge.start,edge.end)) {
				cost += edge.cost;
				if(++cnt == V-1) break;
			}
		}
		System.out.println(cost);
	}
	
	public static void make() {
		parents = new int[V+1];
		parents[0] = -1;
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
		parents[pb] = pa;
		return true;
	}
}
