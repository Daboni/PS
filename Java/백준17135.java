import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준17135 {
	public static int n;
	public static int m;
	public static int d;

	public static int[][] map;
	public static int[] tmp = new int[3];
	
	public static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		go(0, 0);
		System.out.println(ans);
	}

	public static void go(int idx, int cnt) {
		if (cnt == 3) {
			int[][] d = new int[n + 1][m];
			
			for (int c = 0; c < n; c++) {
				for (int r = 0; r < m; r++) {
					d[c][r] = map[c][r];
				}
			}
//			System.out.println(Arrays.toString(tmp));
			for(int i=0;i<3;i++) {
				d[n][tmp[i]]=-1;
			}
			game(d);
			
			return;
		}
		for (int i = idx; i < m; i++) {
			tmp[cnt] = i;
			go(i + 1, cnt + 1);
		}
	}

	public static void game(int[][] comap) {
		int cnt=0;
		
		for(int k=0;k<n;k++) {
			int[][] tmpMap = new int[n+1][m];
			copyMap(comap,tmpMap);
			for(int x : tmp) {
				int atX=987654321;
				int atY=987654321;
				int mindis=987654321;
				
				boolean isOk = false;
				
				for(int i = n-1;i>=0;i--) {
					for(int j=0;j<m;j++) {
						if(comap[i][j] == 1 && isRange(n,x,i,j)) {
							if(mindis>Math.abs(n-i)+Math.abs(x-j)) {
								mindis = Math.abs(n-i)+Math.abs(x-j);
								atX=i;
								atY=j;
							}
							if(mindis==Math.abs(n-i)+Math.abs(x-j)) {
								if(atY>j) {
									atX = i;
									atY = j;
								}
							}
//							tmpMap[i][j] = Math.abs(n-x)+Math.abs(i-j);
						}
					}
				}
				if(atY != 987654321) tmpMap[atX][atY]=0;
			}
			cnt += count(tmpMap,comap);
			copyMap(tmpMap,comap);
			move(comap);
		}
		
		ans = Math.max(ans,cnt);
	}
	private static int count(int[][] map1, int[][] map2) {
		int cnt=0;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<m;j++) {
				if(map2[i][j] != map1[i][j]) cnt++;
			}
		}
		return cnt;
	}

	public static boolean isRange(int ax,int ay, int mx,int my) {
		if(Math.abs(ax-mx)+Math.abs(ay-my)<=d) return true;
		return false;
	}
	public static void move(int[][] comap) {
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<m;j++) {
				comap[i][j] = comap[i-1][j];
			}
		}
		for(int i=0;i<m;i++) {
			comap[0][i] = 0;
		}
	}
	public static void copyMap(int[][] map1, int[][] map2) {
		for(int i=0;i<=n;i++) {
			for(int j=0;j<m;j++) {
				map2[i][j] = map1[i][j];
			}
		}
	}
	
}
