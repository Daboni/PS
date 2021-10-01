import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준4485 {
	
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static int n;
	
	public static int[][] map;
	public static int[][] d;
	
	public static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node(int x,int y,int cost) {
			this.x=x;
			this.y=y;
			this.cost=cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			map = new int[n][n];
			d = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					d[i][j] = 987654321;
				}
			}
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			System.out.println("Problem "+ tc++ +": "+ d[n-1][n-1]);
		}
	}
	public static void bfs() {
		
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0,0,map[0][0]));
		d[0][0] = map[0][0];
		while(!q.isEmpty()) {
			
			Node tmp = q.poll();
			
			for(int k=0;k<4;k++) {
				int nx = tmp.x+dx[k];
				int ny = tmp.y+dy[k];
				
				if(nx>=0&&nx<n&&ny>=0&&ny<n) {
					
					if(d[nx][ny]>d[tmp.x][tmp.y]+map[nx][ny]) {
						d[nx][ny] = d[tmp.x][tmp.y]+map[nx][ny];
						q.add(new Node(nx,ny,d[nx][ny]));
					}
				}
			}
			
		}
		
	}
}
