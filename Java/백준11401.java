import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11401 {
	public static long mod = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[] fac = new long[n+1];
		fac[0]=1;
		for(int i=1;i<=n;i++) {
			fac[i]=fac[i-1]*i%mod;
		}
		
		long ans = fac[n]*(pow(fac[n-k]*fac[k]%mod,mod-2)%mod)%mod;
		System.out.println(ans);
		
	}
	public static long pow(long a,long b) {
		
		if(b==0) return 1;
		
		long tmp = pow(a,b/2)%mod;
		
		if(b%2==1) return tmp*tmp%mod*a%mod;
		else return tmp*tmp%mod;
		
	}
}
