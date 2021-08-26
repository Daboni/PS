import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA하나로_kruskal {
	
	public static class Node implements Comparable<Node>{
		int cur,nxt;
		double cost;
		
		public Node(int cur ,int nxt, double cost) {
			this.cur = cur;
			this.nxt = nxt;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Double.compare(this.cost, o.cost);
		}
		
		
	}
	static int n;
	
	static int[] parents;
	
	
	static void make_set() {
		for(int i=0;i<n;i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa==pb) return false;
		parents[pb] = pa;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(in.readLine());
			
			long[] x = new long[n];
			long[] y = new long[n];
			
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			
			for(int i=0;i<n;i++) {
				x[i]=Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(in.readLine()," ");
			
			for(int i=0;i<n;i++) {
				y[i]=Long.parseLong(st.nextToken());
			}
			parents = new int[n];
			List<Node> nodes = new ArrayList<>();
			double e = Double.parseDouble(in.readLine());
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					nodes.add(new Node(i,j,(Math.pow((x[i]-x[j]),2) + Math.pow((y[i]-y[j]),2))*e));
				}
			}
			make_set();
			Collections.sort(nodes);
			int cnt = 0;
			double ans = 0;
			
			for(Node node:nodes) {
				if(union(node.cur,node.nxt)) {
					ans+=node.cost;
					if(++cnt==(n-1)) break;
				}	
			}
			System.out.printf("#%d %.0f%n",tc,ans);
		}
	}
}
