import java.util.Arrays;
import java.util.Scanner;

public class SWEA1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[][] m = new int[n][n];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					m[i][j] = sc.nextInt();
			
			int[] d = new int[n*n];
			int num = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int cnt=0;					
					if(m[i][j]==1) {
						while(true) {
							if(j>=n || m[i][j]!=1) break;
							cnt++;
							j++;
						}
					}
					if(cnt!=0) {
						d[num]=cnt;
						num++;
					}
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int cnt=0;					
					if(m[j][i]==1) {
						while(true) {
							if(j>=n || m[j][i]!=1) break;
							cnt++;
							j++;
						}
					}
					if(cnt!=0) {
						d[num]=cnt;
						num++;
					}
				}
			}
			int ans = 0;
			
			for(int i=0;i<num;i++) {
				if(d[i]==k) ans++;
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
