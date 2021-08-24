import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 백준1753v2 {
	
	static List<Node>[] adjList;
	
	static class Node{
		int nxt;
		int cost;

		public Node(int nxt,int cost) {
			this.nxt = nxt;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
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
		d[1] = 0;
		for(int i=0;i<v;i++) {
			
			int min = 987654321;
			int minV = -1;
			
			// 방문하지 않은 노드 중에서 거리가 가장 작은 값 찾기
			for(int j=1;j<=v;j++) {
				if(!visited[j] && min>d[j]) {
					min = d[j];
					minV = j;
				}
			}
			if(minV==-1) break;
			visited[minV] = true;
			
			
			for(Node node:adjList[minV]) {
				if(d[node.nxt] > d[minV]+node.cost) d[node.nxt] = d[minV]+node.cost;
			}
		}
		for(int i=1;i<=v;i++) {
			System.out.println(d[i]==987654321?"INF":d[i]);
		}
		
	}
}
