import java.util.*;

public class 동전1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] d = new int[k+1];
		
		int[] coins = new int[n];
		for(int i=0;i<n;i++) coins[i] = sc.nextInt();
		
		d[0] = 1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=k;j++) {
				if(j-coins[i]>=0)
					d[j] += d[j-coins[i]];
			}
		}
		System.out.println(d[k]);
	}
}
