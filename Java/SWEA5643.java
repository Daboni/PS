import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5643 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			int[][] d = new int[n+1][n+1];
			
			for(int i=0;i<=n;i++) {
				for(int j=0;j<=n;j++) {
					if(i==j) d[i][j] = 0;
					else d[i][j] = 987654321;
				}
			}
			
			
			StringTokenizer st;
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				d[a][b] = 1;
			}
			
			for(int k=1;k<=n;k++) {
				for(int i=1;i<=n;i++) {
					if(i==k) continue;
					for(int j=1;j<=n;j++) {
						if(i==j || j==k) continue;
						d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
					}
				}
			}
			int cnt=0;
			for (int i = 1; i <= n; i++) {
				boolean flag = true;
				for (int j = 1; j <= n; j++) {
					if (d[i][j] == 987654321 && d[j][i] == 987654321) {
						flag = false;
						break;
					}
				}
				if (flag) cnt++;
			}
			sb.append("#").append(tc).append(" ").append(cnt);
			System.out.println(sb.toString());
		}
		
	}
}
