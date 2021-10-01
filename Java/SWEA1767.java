import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1767 {
	
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static int n;
	public static int[][] map;
	public static int maxCore;
	public static int minLen;
	public static int INF = 987654321;
	public static List<Core> cores;
	public static class Core{
		int x;
		int y;
		public Core(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			cores = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]==1) {
						if(i==0 || i== n-1 || j==0 || j== n-1) continue;
						cores.add(new Core(i,j));
					}
				}
			}
			
			maxCore = -INF;
			minLen = INF;
			go(0,0,0);
			System.out.printf("#%d %d%n",tc,minLen);
		}
	}
	public static void go(int idx,int cnt, int lines) {
		
		if(idx == cores.size()) {
			if(maxCore<cnt) {
				maxCore=cnt;
				minLen = lines;
			}
			else if(maxCore==cnt) {
				minLen = Math.min(minLen, lines);
			}
			return;
		}
		
		Core core = cores.get(idx);
		int x = core.x;
		int y = core.y;
		
		for(int k=0;k<4;k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			boolean isOK = true;
			int tempCnt = 0;
			
			while(isRange(nx,ny)) {
				
				if(map[nx][ny]!=0) {
					isOK = false;
					break;
				}
				
				nx = nx+dx[k];
				ny = ny+dy[k];
				
				tempCnt++;
			}
			
			if(!isOK) {
				go(idx+1,cnt,lines);
			}
			else {
				
				nx = x+dx[k];
				ny = y+dy[k];
				while(isRange(nx,ny)) {
					
					map[nx][ny] = 1;
					
					nx = nx+dx[k];
					ny = ny+dy[k];
				}
				
				go(idx+1,cnt+1,lines+tempCnt);
				
				nx = x+dx[k];
				ny = y+dy[k];
				while(isRange(nx,ny)) {
					
					map[nx][ny] = 0;
					
					nx = nx+dx[k];
					ny = ny+dy[k];
				}
			}
		}
	}
	public static boolean isRange(int x,int y) {
		if(x < 0 || x >= n || y < 0 || y >= n) return false;
		return true;
	}
}
