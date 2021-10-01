import java.util.Scanner;

public class SWEA3282 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[] v = new int[n+1];
			int[] c = new int[n+1];
			
			for(int i=1;i<n+1;i++) {
				v[i] = sc.nextInt();
				c[i] = sc.nextInt();
			}
//			int[][] d = new int[n+1][k+1];
//			
//			for(int i=1;i<n+1;i++) {
//				for(int j=1;j<k+1;j++) {
//					
//					if(v[i]>j) d[i][j] = Math.max(d[i-1][j],d[i][j-1]);
//					
//					else {
//						d[i][j] = Math.max(d[i-1][j-v[i]]+c[i], d[i-1][j]);
//					}
//					
//				}
//			}
			
			int[] d = new int[k+1];
			
			for(int i=1;i<n+1;i++) {
				for(int j=k;j>=v[i];j--) {
					d[j] = Math.max(d[j-v[i]]+c[i], d[j]);
				}	
			}
			System.out.printf("#%d %d%n",tc,d[k]);
		}
	}
}
