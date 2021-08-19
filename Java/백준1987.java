import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1987 {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	
	static char[][] map;
	static int n,m;
	
	static boolean[] d;

	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		d = new boolean[26];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = s.charAt(j);
			}
		}		
		go(0,0,1);
		System.out.println(ans);
	}
	public static void go(int r,int c,int cnt) {
		
		ans = Math.max(cnt, ans);
		d[map[r][c]-'A'] = true;
		
		for(int k=0;k<4;k++) {
			int nx = r+dx[k];
			int ny = c+dy[k];
			
			if(nx<0 || nx >=n || ny<0 || ny>=m) continue;
			if(d[map[nx][ny]-'A']==true) continue;
			
			go(nx,ny,cnt+1);
			d[map[nx][ny]-'A']=false;
		}
	}
}
