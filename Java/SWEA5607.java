import java.util.Scanner;

public class SWEA5607 {
	static int Mod = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		long[] fac = new long[1000001];
		fac[0] = 1;
		for(int i=1;i<=1000000;i++) {
			fac[i] = fac[i-1]*i%Mod;
		}
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			
			long ans = fac[n]*(pow(fac[n-r]*fac[r]%Mod,Mod-2)%Mod)%Mod;
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	static long pow(long n, long m) {
		if(m==1)
			return n;
		long tmp = pow(n,m/2)%Mod;
		if(m%2==1) 
			return tmp*tmp%Mod*n%Mod;
		else
			return tmp*tmp%Mod;
	}
}
