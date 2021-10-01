import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준1937 {
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };

	public static int[][] map;
	public static int[][] visited;

	public static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new int[n][n];
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans = Math.max(dfs(i, j),ans);
			}
		}
		bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
	}	
	public static int ans=0;
	public static int dfs(int x, int y) {

		if(visited[x][y] != 0) {
			return visited[x][y];
		}
		
		visited[x][y] = 1;
		
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			if (map[nx][ny] > map[x][y]) {
				visited[x][y] = Math.max(visited[x][y], dfs(nx,ny)+1);
				dfs(nx,ny);
			}
		}
		return visited[x][y];
	}
}
