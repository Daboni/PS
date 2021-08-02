import java.util.Scanner;

public class SWEA1220 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			int ans=0;
			for(int i=0;i<n;i++) {
				int ok = 0;
				for(int j=0;j<n;j++) {
					if(a[j][i]==1) ok = 1;
					else if(a[j][i]==2) {
						if(ok == 1) {
							ans+=1;
						}
						ok = 0;						
					}
					else continue;
				}
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
