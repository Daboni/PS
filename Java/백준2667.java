import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 백준2667 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n;
	static int[][] map;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		
		n = sc.nextInt();
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			String s = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) {
					cnt++;
					d.add(0);
					dfs(i,j);
				}
			}
		}
		Collections.sort(d);
		System.out.println(cnt);
		for(int x:d) System.out.println(x);
	}
	
	static ArrayList<Integer> d = new ArrayList<Integer>();
	
	public static void dfs(int i,int j) {
		
		map[i][j] = 0;
		d.set(cnt-1,d.get(cnt-1)+1);
		for(int k=0;k<4;k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx < 0 || nx >= n || ny<0 || ny>=n || map[nx][ny]==0) continue;
			dfs(nx,ny);
		}
		
		
	}
}
