import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA1249 {
	
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
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++){
			n =Integer.parseInt(br.readLine());
			map = new int[n][n];
			d = new int[n][n];
			
			for(int i=0;i<n;i++) {
				String s = br.readLine();
				for(int j=0;j<n;j++) {
					map[i][j] = s.charAt(j)-'0';
					d[i][j] = 987654321;
				}
			}
			
			bfs();
			System.out.println("#"+tc+" "+d[n-1][n-1]);
		}
	}
	public static void bfs() {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(0,0,0));
		d[0][0] = 0;
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			
			for(int k=0;k<4;k++){
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(isRange(nx,ny)) {
					if(d[nx][ny]>d[x][y]+map[nx][ny]) {
						d[nx][ny] = d[x][y]+map[nx][ny];
						q.add(new Node(nx,ny,d[nx][ny]));
					}
				}
			}
			
		}
		
	}
	public static boolean isRange(int nx,int ny) {
		if(nx<0||nx>=n||ny<0||ny>=n) return false;
		return true;
	}
}
