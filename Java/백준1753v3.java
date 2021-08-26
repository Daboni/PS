import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준1753v3 {
static List<Node>[] adjList;
	
	static class Node implements Comparable<Node>{
		int nxt;
		int cost;

		public Node(int nxt,int cost) {
			this.nxt = nxt;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(in.readLine());
		adjList = new ArrayList[v+1];
		
		for(int i=1;i<=v;i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(in.readLine()," ");
			int sv = Integer.parseInt(st.nextToken());
			int ev = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[sv].add(new Node(ev,c));
		}
		
		boolean[] visited = new boolean[v+1];
		int[] d = new int[v+1];
		Arrays.fill(d, 987654321);
		d[start] = 0;
		
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(start,0));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int ver = cur.nxt;
			int cost = cur.cost;
			if(d[ver]<cost) continue;
			for(int i=0;i<adjList[ver].size();i++) {
				int v2 = adjList[ver].get(i).nxt;
				int co2 = adjList[ver].get(i).cost + cost;
				if(d[v2] > co2) {
					d[v2] = co2;
					q.add(new Node(v2,co2));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= v; i++){
            if(d[i] == 987654321) sb.append("INF\n");
            else sb.append(d[i] + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        in.close();
	}
}
