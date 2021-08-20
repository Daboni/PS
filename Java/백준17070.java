import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준17070 {

	static int ans,n;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(sc.readLine());
		
		map = new char[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(sc.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j]==1) map[i][j] = 'X';
			}
		}
		map[0][0] = '1';
		map[0][1] = '1';
		go(0,1);
		System.out.println(ans);
	}
	public static void go(int r,int c) {
		
		if(r==n-1 && c==n-1) {
			ans++;
			return;
		}
		//case 1
		if(map[r][c]=='1') {
			if(c+1<n && map[r][c+1]=='0') {
				map[r][c+1]='1';
				go(r,c+1);
				map[r][c+1]='0';
				
			}
			if(c+1<n && r+1<n && map[r][c+1]=='0' && map[r+1][c+1]=='0' && map[r+1][c]=='0') {
				map[r+1][c+1]='3';
				go(r+1,c+1);
				map[r+1][c+1]='0';
			}
		}
		//case2
		if(map[r][c]=='2') {
			if(r+1<n && map[r+1][c]=='0') {
				map[r+1][c]='2';
				go(r+1,c);
				map[r+1][c]='0';
			}
			if(c+1<n && r+1<n && map[r][c+1]=='0' && map[r+1][c+1]=='0' && map[r+1][c]=='0') {
				map[r+1][c+1]='3';
				go(r+1,c+1);
				map[r+1][c+1]='0';
			}
		}
		//case3
		if(map[r][c]=='3') {
			if(c+1<n && map[r][c+1]=='0') {
				map[r][c+1]='1';
				go(r,c+1);
				map[r][c+1]='0';
				
			}
			if(r+1<n && map[r+1][c]=='0') {
				map[r+1][c]='2';
				go(r+1,c);
				map[r+1][c]='0';
			}
			if(c+1<n && r+1<n && map[r][c+1]=='0' && map[r+1][c+1]=='0' && map[r+1][c]=='0') {
				map[r+1][c+1]='3';
				go(r+1,c+1);
				map[r+1][c+1]='0';
			}
		}

	}
}
