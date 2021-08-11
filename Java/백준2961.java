import java.util.Scanner;

public class 백준2961 {
	static long[] a;
	static long[] b;
	static int n;
	
	static long min = Integer.MAX_VALUE;
	
	public static void go(int idx,long sin, long jjan,int cnt) {
		
		if(idx==n) {
			if(cnt==0) return;
			min = Math.min(min, Math.abs(sin-jjan));
			return;
		}
		
		go(idx+1,sin*a[idx],jjan+b[idx],cnt+1);
		go(idx+1,sin,jjan,cnt);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		a = new long[n];
		b = new long[n];
			
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
			b[i]= sc.nextInt();
		}
		go(0,1,0,0);
		System.out.println(min);
		
	}
}
