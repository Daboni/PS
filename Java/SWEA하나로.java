import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA하나로 {
	public static class Node implements Comparable<Node>{
		int nxt;
		double cost;
		public Node(int nxt,double cost) {
			this.nxt=nxt;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
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
			double e = Double.parseDouble(in.readLine());
			
			List<List<Node>> adjList = new ArrayList<>();
			for(int i=0;i<n;i++) {
				adjList.add(new ArrayList<>());
				
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					double L =Math.pow((x[i]-x[j]),2) + Math.pow((y[i]-y[j]),2);
					adjList.get(i).add(new Node(j,L*e));
				}
			}
			
			boolean[] visited = new boolean[n];
			double[] d = new double[n];
			Arrays.fill(d, Double.MAX_VALUE);
			d[0] = 0;
			double ans=0;
			for(int i=0;i<n;i++) {
				
				double min=Double.MAX_VALUE;
				int minV=-1;
				
				for(int j=0;j<n;j++) {
					if(!visited[j] && min>d[j]) {
						min = d[j];
						minV = j;
					}
				}
				ans += min;
				visited[minV] = true;
				if(minV==-1) break;
				for (int j = 0; j < n; j++) {
					if(!visited[j] && d[j]> adjList.get(minV).get(j).cost) {
						d[j] = adjList.get(minV).get(j).cost;
					}
				}
//				for(Node node:adjList.get(minV)) {
//					if(d[node.nxt] > d[minV]+ node.cost) {
//						d[node.nxt] = d[minV]+ node.cost;
//					}
//				}
			}
			System.out.printf("#%d %.0f%n",tc,ans);
		}
	}
}
