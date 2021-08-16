import java.util.Arrays;
import java.util.Scanner;

public class น้มุ2309v2 {
	static public int[] a = new int[9];
	static public boolean[] d = new boolean[9];

	public static void go(int idx,int cnt) {
		
		if(cnt == 7 || idx ==9) {
			int sum=0;
			for(int i=0;i<9;i++) {
				if(d[i]) sum+=a[i];
			}
			if(sum==100) {
				for(int i=0;i<9;i++) {
					if(d[i]) System.out.println(a[i]);
				}
				System.exit(0);
			}
			return;
		}
		d[idx] = true;
		go(idx+1,cnt+1);
		d[idx] = false;
		go(idx+1,cnt);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<9;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		go(0,0);
	}
}
