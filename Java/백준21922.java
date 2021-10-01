import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준21922 {
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static int[][] map;
	public static int[][][] d;

	public static int n;
	public static int m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		d = new int[n][m][4];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9)
					for(int k=0;k<4;k++) {
						d[i][j][k] = 9;
					}

			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 9)
					for(int k=0;k<4;k++)
						check(i,j,k);
			}
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<4;k++) {
					if(d[i][j][k] == 9) {
						ans++;
						break;
					}
				}
			}
		}
		bw.write(ans+"\n");
		bw.flush();
	}

	public static void check(int x, int y,int k) {

		int dir = k;
		int nx = x+dx[dir];
		int ny = y+dy[dir];
		
		while (isRange(nx, ny)) {
			if(d[nx][ny][dir] == 9) break;
			d[nx][ny][dir] = 9;
			if (map[nx][ny] == 1) {
				if(dir == 1 || dir == 3) break;
			} else if (map[nx][ny] == 2) {
				if(dir == 0 || dir == 2) break;
			} else if (map[nx][ny] == 3) {
				if (dir == 0) dir = 1;
				else if(dir == 1) dir = 0;
				else if (dir == 2) dir = 3;
				else if (dir == 3) dir = 2;
			} else if(map[nx][ny] == 4){
				if (dir == 0) dir = 3;
				else if(dir == 1) dir = 2;
				else if (dir == 2) dir = 1;
				else if (dir == 3) dir = 0;
			}
			nx = nx+dx[dir];
			ny = ny+dy[dir];
		}

	}

	public static boolean isRange(int nx, int ny) {
		if (nx < 0 || nx >= n || ny < 0 || ny >= m)
			return false;
		return true;
	}
}
