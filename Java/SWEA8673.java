import java.util.Scanner;

public class SWEA8673 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int m=1;
			for(int i=0;i<n;i++) {
				m*=2;
			}
			int[] a = new int[m];
			for(int i=0;i<m;i++) {
				a[i] = sc.nextInt();
			}
			int ans = 0;

			while(m>1) {
				int j = 0;
				for(int i=0;i<m;i+=2) {
					ans+= Math.abs(a[i]-a[i+1]);
					a[j++]=Math.max(a[i], a[i+1]);
				}
				m/=2;
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
