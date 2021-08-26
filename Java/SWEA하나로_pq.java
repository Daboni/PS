import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA하나로_pq {
	
	static class Node implements Comparable<Node>{
		int nxt;
		double cost;
		public Node(int nxt,double cost) {
			this.nxt = nxt;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.cost, o.cost);
		}
		
	}
	static double[][] adjMatrix;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(in.readLine());
			
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
			adjMatrix = new double[n][n];

			double e = Double.parseDouble(in.readLine());

			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					adjMatrix[i][j] = (Math.pow((x[i]-x[j]),2) + Math.pow((y[i]-y[j]),2))*e;
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0,0));
			double[] d = new double[n];
			Arrays.fill(d, Double.MAX_VALUE);
			d[0] = 0;
			double ans = 0;
			while(!pq.isEmpty()) {
				
				Node node = pq.poll();
				if(d[node.nxt]<node.cost) continue;
				ans += node.cost;
				
				for(int j=0;j<n;j++) {
					if(d[j]>adjMatrix[node.nxt][j]) {
						d[j] =adjMatrix[node.nxt][j];
						pq.add(new Node(j,adjMatrix[node.nxt][j]));
					}
				}
			}
			System.out.printf("#%d %.0f%n",tc,ans);

		}
	}
}
