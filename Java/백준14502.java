import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준14502 {
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {1,-1,0,0};
	
	public static int n;
	public static int m;
	
	public static int[][] map;
	
	public static Queue<int[]> q;
	
	public static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0);
		System.out.println(ans);
	}
	public static void comb(int cnt) {
		
		if(cnt==3) {
			
			ans = Math.max(ans,bfs());
			return;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					comb(cnt+1);
					map[i][j]=0;					
				}
			}
		}
	}
	public static int bfs() {
		
		int[][] d = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				d[i][j] = map[i][j];
				if(d[i][j]==2) q.add(new int[] {i,j});
			}
		}
		
		while(!q.isEmpty()) {
			
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(isRange(nx,ny)) {
					if(d[nx][ny]==0) {
						d[nx][ny]=2;
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
		int isSafe = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(d[i][j] == 0) isSafe++;
			}
		}
		return isSafe;
	}
	public static boolean isRange(int nx,int ny) {
		if(nx<0||nx>=n||ny<0||ny>=m) return false;
		return true;
	}
}
