import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class 백준7576 {
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {1,-1,0,0};
	
	public static int n;
	public static int m;
	public static int[][] map;
	public static int[][] d;
	public static Queue<Tomato> q;
	
	public static class Tomato{
		int x;
		int y;
		
		public Tomato(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		map = new int[n][m];
		d = new int[n][m];
		
		q = new LinkedList<>();

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1) q.add(new Tomato(i,j));
				
			}
		}
		bfs();
		int ans = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(d[i][j]==0&&map[i][j]==0) {
					System.out.println(-1);
					return;
				}
				if(ans<d[i][j]) {
					ans = d[i][j];
				}
			}
		}
		System.out.println(ans);
	}
	public static void bfs() {
		
		while(!q.isEmpty()) {
			
			Tomato t = q.poll();
			int x = t.x;
			int y = t.y;
			
			for(int k=0;k<4;k++) {
				
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(isRange(nx,ny)&&map[nx][ny]==0) {
					
					if(d[nx][ny]==0) {
						
						q.add(new Tomato(nx,ny));
						d[nx][ny] = d[x][y]+1;
						map[nx][ny] = 1;
					}
					
				}
				
			}
			
		}
	}
	public static boolean isRange(int x,int y) {
		if(x<0 || x>=n || y<0 || y>= m) return false;
		return true;
	}
}
