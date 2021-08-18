import java.util.Arrays;
import java.util.Scanner;

public class 백준2468 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n;
	static int[][] map;
	static int[][] d;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		d = new int[n][n];
		int max = -1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		for(int k=0;k<=max;k++) {
			for(int i=0;i<n;i++) {
				d[i] = Arrays.copyOf(map[i], n);
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(d[i][j]<=k) d[i][j] = 0;
				}
			}
			int cnt=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(d[i][j] != 0) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			ans = Math.max(ans,cnt);
		}
		System.out.println(ans);

	}
	
	static void dfs(int i,int j) {
		d[i][j] = 0;
		
		for(int k=0;k<4;k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx < 0 || nx >=n || ny<0 || ny>=n || d[nx][ny] ==0 ) continue;
			dfs(nx,ny);
		}
	}
}
