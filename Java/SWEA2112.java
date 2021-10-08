import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2112 {
	public static int n;
	public static int m;
	public static int k;
	
	public static int[][] map;
	public static int[][] tmp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			tmp = new int[n][m];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tmp[i][j] = map[i][j];
				
				}
			}
			
			for(int i=0;i<n;i++) {
				if(comb(0,0,i)) {
					System.out.printf("#%d %d%n",tc,i);
					break;
				}
			}
			
		}
	}
	public static boolean comb(int idx,int cnt, int maxCnt) {
		
		if(maxCnt==cnt) {
			if(check()) return true;
			return false;
		}
		for(int i=idx;i<n;i++) {
			Arrays.fill(tmp[i],0);
			if(comb(i+1,cnt+1,maxCnt)) return true;
			reback(tmp,i);
			
			Arrays.fill(tmp[i],1);
			if(comb(i+1,cnt+1,maxCnt)) return true;
			reback(tmp,i);
		}
		
		return false;
		
	}
	public static void reback(int[][] arr,int cur) {
		for(int i=0;i<arr[0].length;i++)
			arr[cur][i] = map[cur][i];
	}
	public static boolean check() {
		for(int i=0;i<m;i++) {
			int cur = tmp[0][i];
			int ans = 0;
			for(int j=0;j<n;j++) {
				if(tmp[j][i]==cur) ans++;
				else {
					cur = tmp[j][i];
					ans = 1;
				}
				if(ans == k) break;
			}
			if(ans!=k) {
				return false;
			}
		}
		return true;
	}
}
