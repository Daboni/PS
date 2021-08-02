import java.util.Scanner;

public class SWEA1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			long[] a = new long[n];
			for(int i=0;i<n;i++) a[i] = sc.nextInt();
			long ans=0;
			long max=a[n-1];
			for(int i=n-2;i>=0;i--) {
				if(max>a[i]) ans += (max - a[i]);
				else
					max = a[i];
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
		
	}
}
