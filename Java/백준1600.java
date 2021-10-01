import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준1600 {
	
	static class node{
		int x;
		int y;
		int z;
		int cnt;
		public node(int x,int y,int z, int cnt) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.cnt= cnt;
		}
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[] hx = {1,2,2,1,-1,-2,-2,-1};
	static int[] hy = {2,1,-1,-2,-2,-1,1,2};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][][] d = new boolean[n][m][k+1];
		
		Queue<node> q = new LinkedList<node>();
		q.add(new node(0,0,0,0));
		d[0][0][0] = true;
		
		while(!q.isEmpty()) {
			
			node no = q.poll();
//			int x = no.x;
//			int y = no.y;
//			int z = no.z;
//			int cnt = no.cnt;
			
			if(no.x==n-1 && no.y==m-1) {
				System.out.println(no.cnt);
				return;
			}
			if(no.z<k) {
				for(int i=0;i<8;i++) {
					int nx = no.x+hx[i];
					int ny = no.y+hy[i];
					
					if(nx<0 || nx >= n || ny <0 || ny>=m) continue;
					if(map[nx][ny]!=0 || d[nx][ny][no.z+1] != false) continue;
						
					d[nx][ny][no.z+1] = true;
					q.add(new node(nx,ny,no.z+1,no.cnt+1));
				}
			}
			
			for(int i=0;i<4;i++) {
				int nx = no.x+dx[i];
				int ny = no.y+dy[i];
				
				if(nx<0 || nx >= n || ny <0 || ny>=m) continue;
				if(map[nx][ny]!=0 || d[nx][ny][no.z] != false) continue;
				
				d[nx][ny][no.z] = true;
				q.add(new node(nx,ny,no.z,no.cnt+1));
			}
		}	
		System.out.println(-1);
	}
}
