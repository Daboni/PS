import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 백준2667v2 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n;
	static int[][] map;
	static int cnt;
	static int[][] d;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		
		n = sc.nextInt();
		map = new int[n][n];
		d = new int[n][n];
		for(int i=0;i<n;i++) {
			String s = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1 && d[i][j]==0) {
					cnt++;
					bfs(i,j);
				}
			}
		}
		int[] ans = new int[cnt];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(d[i][j]==0) continue;
				ans[d[i][j]-1]++;
			}
		}
		Arrays.sort(ans);
		System.out.println(cnt);
		for(int x:ans) {
			System.out.println(x);
		}
	}
	public static void bfs(int i,int j) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i,j});
		d[i][j]= cnt;
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx < 0 || nx>= n || ny<0 || ny>=n) continue;
				if(d[nx][ny] != 0) continue;
				if(map[nx][ny]==1) {
					d[nx][ny] = cnt;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}
}
