import java.util.Scanner;

public class SWEA2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int[][] d = new int[n][n];
			int ans = 0;
			
			for(int i=0;i<n;i++) {
				String s = sc.next();				
				for(int j=0;j<n;j++) {
					d[i][j] = Integer.valueOf(s.charAt(j))-Integer.valueOf('0');
				}
			}
			for(int i=0;i<n/2+1;i++) {
				int k = 0;
				for(int j=0;j<n;j++) {
					if(j<(n/2)-i) continue;
					if(k<(2*i+1)) {
						ans+= d[i][j];
						k++;
					}
				}
			}
			for(int i=n/2+1;i<n;i++) {
				int k = 0;
				for(int j=0;j<n;j++) {
					if(j<i-n/2) continue;
					if(k<-2*(i-n/2)+n) {
						ans += d[i][j];
						k++;
					}
				}
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
