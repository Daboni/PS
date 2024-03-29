import java.util.*;


public class 동전2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coins = new int[n];
		int[] d = new int[k+1];
		
		for(int i=0;i<n;i++) coins[i] = sc.nextInt();
		Arrays.fill(d, -1);
		d[0]=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=k;j++) {
				if(j-coins[i]>=0 && d[j-coins[i]]!=-1) {
					if(d[j]==-1|| d[j]>d[j-coins[i]]+1)
						d[j] = d[j-coins[i]]+1;
					}
			}
		}
		System.out.println(d[k]);
	}
}
