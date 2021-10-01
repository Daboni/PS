import java.util.Scanner;

public class SWEA6026 {
	public static long mod = 1000000007;
	public static long[] fac;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		fac = new long[101];
		fac[0]=1;
		fac[1]=1;
		for(int i=2;i<=100;i++) {
			fac[i] = fac[i-1]*i%mod;
		}
		
		for(int tc=1;tc<=T;tc++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			long ans = 0;
			
			for(int i=0;i<m;i++) {
				ans = (ans%mod + pow(-1,i)*(comb(m,m-i)%mod*pow(m-i,n)%mod))%mod;
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
	public static long pow(long a,long b) {
		if(b==0) return 1;
		long tmp = pow(a,b/2);
		
		if(b%2==1) return tmp*tmp%mod*a%mod;
		else return tmp*tmp%mod;
	}
	public static long comb(int a,int b) {
		
		// nCr = n!((n-r)!r!)^mod-2
		return fac[a]*(pow(fac[a-b]*fac[b]%mod,mod-2)%mod)%mod;
	}
}
