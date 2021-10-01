import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1238 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int des = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			Arrays.fill(map[i],987654321);
			map[i][i] = 0;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[start][end] = cost;
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				if(k==i) continue;
				for(int j=1;j<=n;j++) {
					if(i==j) continue;
					if(k==j) continue;
					
					map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
					
				}
			}
		}
		int ans = -1;
		for(int i=1;i<=n;i++) {
			
			ans = Math.max(ans,map[i][des]+map[des][i]);
		}
		System.out.println(ans);
	}
}
