import java.util.Scanner;

public class SWEA1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++)
		{
			
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			
			int cnt = 1;
			for(int k=0;k<=n/2;k++) {
				for(int i=k;i<n-k;i++) {
					a[k][i] = cnt;
					cnt++;
				}
				for(int i=1+k;i<n-k;i++) {
					a[i][n-1-k] = cnt;
					cnt++;
				}
				for(int i=1+k;i<n-k;i++) {
					a[n-1-k][n-1-i] = cnt;
					cnt++;
				}
				for(int i=1+k;i<n-k-1;i++) {
					a[n-1-i][k] = cnt;
					cnt++;
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
		}
		
	}
}
