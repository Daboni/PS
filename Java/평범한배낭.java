import java.util.*;

public class 평범한배낭 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		int[][] d = new int[n+1][k+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				d[i][j] = d[i-1][j];
				if(j-a[i]>=0) {
					d[i][j] = Math.max(d[i][j],d[i-1][j-a[i]]+b[i]);
				}
			}
		}
		System.out.println(d[n][k]);
	}
}
