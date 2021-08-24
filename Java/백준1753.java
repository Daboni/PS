import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1753 {

	public static class Node{
		int vertex,cost;
		Node link;
		public Node(int s,int c,Node link) {
			this.vertex = s;
			this.cost = c;
			this.link = link;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		Node[] adjList= new Node[v+1];
		
		int s = Integer.parseInt(in.readLine());
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(in.readLine()," ");
			int sv = Integer.parseInt(st.nextToken());
			int ev = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[sv] = new Node(ev,c,adjList[sv]);
		}
		
		boolean[] visited = new boolean[v+1];

		int[] d = new int[v+1];
		for(int i=1;i<=v;i++) {
			d[i]=987654321;
		}
		d[s] = 0;

		for(int i=0;i<v;i++) {
			
			int min = 987654231;
			int minV = -1;
		
			for(int j=1;j<=v;j++) {
				if(!visited[j] && min>d[j]) {
					min = d[j];
					minV = j;
				}
			}
			if(minV==-1) break;
			
			visited[minV] = true;
			
			for(Node tmp = adjList[minV]; tmp!=null; tmp = tmp.link) {
				if(d[tmp.vertex]>d[minV]+tmp.cost) {
					d[tmp.vertex]=d[minV]+tmp.cost;
				}
			}
		}
		for(int i=1;i<=v;i++) {
			System.out.println(d[i]==987654321?"INF":d[i]);
		}
	}
}
