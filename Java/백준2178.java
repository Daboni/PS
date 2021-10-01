import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2178 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[][] d = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[]{0,0});
		d[0][0]=1;
		
		while(!q.isEmpty()) {
			
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx<0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 0) continue;
				
				if(d[nx][ny] != 0) continue;
				
				d[nx][ny] = d[x][y]+1;
				q.add(new int[]{nx,ny});
			}
		}
		System.out.println(d[n-1][m-1]);
		
	}
}
