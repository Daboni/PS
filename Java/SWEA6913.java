import java.util.Scanner;

public class SWEA6913 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] d = new int[n][m];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					d[i][j] = sc.nextInt();
				}
			}
			int max=0;
			int res=0;
			for(int i=0;i<n;i++) {
				int ans=0;
				for(int x:d[i]) {
					ans+=x;
				}
				if(max<ans) {
					max=ans;
					res=1;
				}
				else if(max==ans) res++;
				
			}
			System.out.printf("#%d %d %d%n",tc,res,max);
		}
	}
}
