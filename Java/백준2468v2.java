import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준2468v2 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n;
	static int[][] map;
	static int[][] d;
	static int ans;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		int max = -1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		for(int k=0;k<=max;k++) {

			cnt=0;
			d = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] > k && d[i][j] == 0) {
						cnt++;
						bfs(i,j,k);
					}
				}
			}
			ans = Math.max(ans,cnt);
		}
		System.out.println(ans);

	}
	static void bfs(int i,int j, int k) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {i,j});
		d[i][j] = cnt;
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			for(int s=0;s<4;s++) {
				int nx = x+dx[s];
				int ny = y+dy[s];	
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny]<=k) continue;
				if(d[nx][ny] != 0) continue;
				d[nx][ny] = cnt;
				q.offer(new int[] {nx,ny});
			}
		}
		
	}
}
