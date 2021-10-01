import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2206 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
	    int[][] map = new int[n][m];
	    int[][][] d = new int[n][m][2];
	    
	    for(int i=0;i<n;i++) {
	    	String s = br.readLine();
	    	for(int j=0;j<m;j++) {
	    		map[i][j] = s.charAt(j)-'0';
	    	}
	    }
	    
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {0,0,0});
		d[0][0][0]=1;
	    while(!q.isEmpty()) {
	    	
	    	int x = q.peek()[0];
	    	int y = q.peek()[1];
	    	int bk = q.peek()[2];
	    	q.poll();
	    	for(int k=0;k<4;k++) {
	    		
	    		int nx = x+dx[k];
	    		int ny = y+dy[k];
	    		
	    		if(0 <= nx && nx < n && 0 <= ny && ny < m) {
	    			
	    			if(map[nx][ny] == 0 && d[nx][ny][bk] == 0) {
	    				d[nx][ny][bk] = d[x][y][bk]+1;
	    				q.add(new int[] {nx,ny,bk});
	    			}
	    			if(bk == 0 && map[nx][ny] ==1 && d[nx][ny][bk]==0) {
	    				d[nx][ny][bk+1] = d[x][y][bk] + 1;
	    				q.add(new int[] {nx,ny,bk+1});
	    			}
	    		}
	    	}
	    }
	    if(d[n-1][m-1][0]!=0 && d[n-1][m-1][1]!=0) {
	    	System.out.println(Math.min(d[n-1][m-1][0],d[n-1][m-1][1]));
	    }
	    else if(d[n-1][m-1][0]!=0) {
	    	System.out.println(d[n-1][m-1][0]);
	    }
	    else if(d[n-1][m-1][1]!=0) {
	    	System.out.println(d[n-1][m-1][1]);
	    }
	    else {
	    	System.out.println(-1);
	    }
	}
}
