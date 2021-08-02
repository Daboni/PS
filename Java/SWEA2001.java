import java.util.Scanner;

public class SWEA2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[][] map = new int[n][n];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					map[i][j] = sc.nextInt();
			int ans = 0;
			for(int p=0;p<=n-k;p++) {
				for(int s=0;s<=n-k;s++) {
					int cnt=0;
					for(int i=p;i<k+p;i++) {
						for(int j=s;j<s+k;j++) {
							cnt+=map[i][j];
						}
					}
					ans=Math.max(ans, cnt);
				}
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
