import java.util.Scanner;

public class 농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			
			for(int i=0;i<n;i++) {
				String s = sc.next();
				for(int j=0;j<n;j++) {
					a[i][j] = s.charAt(j)-'0';
				}
			}
			
			int ans = 0;
			for(int i=0;i<=n/2;i++) {
				int k =0;
				for(int j=0;j<n;j++) {
					if(j<n/2-i) continue;
					if(k<2*i+1) {
						ans += a[i][j];
						k++;
					}
				}
			}
			
			for(int i=n/2+1;i<n;i++) {
				int k =0;
				for(int j=0;j<n;j++) {
					if(j<(i-n/2)) continue;
					if(k<-2*(i-n/2)+n) {
						ans += a[i][j];
						k++;
					}
				}
			}
			System.out.printf("#%d %d%n",tc,ans);
			
			
		}
		
	}
}
