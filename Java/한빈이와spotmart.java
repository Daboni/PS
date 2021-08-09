import java.util.Scanner;

public class 한빈이와spotmart {
	static int n;
	static int m;
	static int[] a;
	static int max;
	
	public static void go(int idx, int weights,int cnt) {
		
		if(weights>m) return;
		if(cnt == 2) {
			max = Math.max(max, weights);
			return;
		}
		if(idx>=n) return;
		
		go(idx+1,weights+a[idx],cnt+1);
		go(idx+1,weights,cnt);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			a = new int[n];
			max = 0;
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			go(0,0,0);
			System.out.printf("#%d %d%n",tc,max==0?-1:max);
		}
	}
}
