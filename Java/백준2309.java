import java.util.Arrays;
import java.util.Scanner;

public class น้มุ2309 {
	static public int[] a = new int[9];
	static public int[] ans = new int[7];
		
	public static void go(int idx,int sum,int cnt) {
		
		if(sum>100) return;
		if(cnt == 7 || idx ==9) {
			if(sum==100) {
				for(int i=0;i<7;i++) {
					System.out.println(ans[i]);
				}
				System.exit(0);
			}
			return;
		}
		ans[cnt] = a[idx];
		go(idx+1,sum+a[idx],cnt+1);
		ans[cnt] = 0;
		go(idx+1,sum,cnt);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<9;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		go(0,0,0);
	}
}
