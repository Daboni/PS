import java.util.Scanner;

public class 부분수열의합 {
	// 사용할 변수들을 선언
	public static int[] a;
	public static int n;
	public static int k;
	public static int ans;
	
	public static void go(int idx,int sum) {
		if(sum>k) return;
		if(idx==n) {
			if(sum==k) ans++;
			return;
		}
		go(idx+1,sum+a[idx]);
		go(idx+1,sum);
	}

public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			n = sc.nextInt();
			k = sc.nextInt();
			
			a = new int[n];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			ans = 0;
			go(0,0);
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
