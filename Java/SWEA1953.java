import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953 {
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	public static int n;
	public static int m;
	public static int l;
	public static int[][] map;
	public static int[][] d;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			d = new int[n][m];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(sx,sy);
			int ans = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(d[i][j]!=0 && d[i][j] <= l) ans++;
				}
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
		
	}
	public static void bfs(int sx,int sy) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sx,sy});
		d[sx][sy] = 1;
		
		while(!q.isEmpty()) {
			
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			if(d[x][y]>l) break;
			
			for(int k=0;k<4;k++){
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(isRange(nx,ny) && map[nx][ny]!=0) {
					if(d[nx][ny] != 0) continue;
					
					if(map[nx][ny]==1) {
						if(map[x][y]==1) {
							d[nx][ny] = d[x][y]+1;
							q.add(new int[] {nx,ny});
						}
						if(map[x][y]==2 || map[x][y]==5 || map[x][y]==6) {
							if(k==2) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});								
							}
						}
						if(map[x][y]==3 || map[x][y]==6 || map[x][y]==7) {
							if(k==3) {	
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});								
							}
						}
						if(map[x][y]==2 || map[x][y]==4 || map[x][y]==7) {
							if(k==0) {	
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});								
							}
						}
						if(map[x][y]==3 || map[x][y]==4 || map[x][y]==5) {
							if(k==1) {	
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});								
							}
						}
						
					}
					else if(map[nx][ny] == 2) {
						if(map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 4 || map[x][y] == 7) {
							if(k==0) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});
							}	
						}
						if(map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 5 || map[x][y] == 6) {
							if(k==2) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});
							}	
						}
						
					}
					else if(map[nx][ny] == 3) {
						if(map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 5) {
							if(k==1) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});
							}							
						}
						if(map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 6 || map[x][y] == 7) {
							if(k==3) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});
							}							
						}
					}
					else if(map[nx][ny] == 4) {
						if(map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 5 || map[x][y] == 6) {
							if(k==2) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});								
							}
						}
						if(map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 6 || map[x][y] == 7) {
							if(k==3) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});								
							}
						}
					}
					else if(map[nx][ny] == 5) {
						if(map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 4 || map[x][y] == 7) {
							if(k==0) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});	
							}
						}
						if(map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 6 || map[x][y] == 7) {
							if(k==3) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});
							}
						}
					}
					else if(map[nx][ny] == 6) {
						if(map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 5) {
							if(k==1) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});
							}
						}
						if(map[x][y] == 1|| map[x][y] == 2 || map[x][y] == 4 || map[x][y] == 7) {
							if(k==0) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});
							}
						}
					}
					else if(map[nx][ny] == 7) {
						if(map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 5 || map[x][y] == 6) {
							if(k==2) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});
							}
						}
						if(map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 5) {
							if(k==1) {
								d[nx][ny] = d[x][y]+1;
								q.add(new int[] {nx,ny});
							}
						}
					}
				}
			}
			
		}
		
	}
	public static boolean isRange(int nx,int ny) {
		if(nx<0||nx>=n||ny<0||ny>=m) return false;
		return true;
	}
}
