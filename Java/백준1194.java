import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준1194 {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static int n;
	static int m;
	
	public static class Node{
		
		int x;
		int y;
		int state;
		int cnt;
		public Node(int x,int y,int state,int cnt) {
			this.x = x;
			this.y = y;
			this.state = state;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[n][m];
		boolean[][][] d = new boolean[n][m][1<<6];
		
		Queue<Node> q = new LinkedList<>();

		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '0') {
					q.add(new Node(i,j,0,0));
					d[i][j][0] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			Node cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int state = cur.state;
			int cnt = cur.cnt;
			
			if(map[x][y]=='1') {
				System.out.println(cnt);
				return;
			}
			
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(isRange(nx,ny)&&map[nx][ny]!='#') {
					
					if(d[nx][ny][state]) continue;
					
					if(isKey(map[nx][ny])) {
						int nState = state|(1<<(map[nx][ny]-'a'));
						q.add(new Node(nx,ny,nState,cnt+1));
						d[nx][ny][nState] = true;
					}
					else if(isDoor(map[nx][ny])) {
						if((state&(1<<map[nx][ny]-'A'))>0) {
							q.add(new Node(nx,ny,state,cnt+1));
							d[nx][ny][state] = true;
						}
					}
					else {
						q.add(new Node(nx,ny,state,cnt+1));
						d[nx][ny][state] = true;
					}
				}
				
			}
			
		}
		
		System.out.println(-1);
		
	}
	public static boolean isRange(int x,int y) {
		if(x<0||x>=n||y<0||y>=m) return false;
		return true;
	}
	public static boolean isKey(char c) {
		if(c<'a' || c>'z') return false;
		return true;
	}
	public static boolean isDoor(char c) {
		if(c<'A' || c>'Z') return false;
		return true;
	}
	
}
