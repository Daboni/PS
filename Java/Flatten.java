import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int n = sc.nextInt();
			
			int[] a = new int[100];
			for(int i=0;i<100;i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);

			while(n-->0) {
				if(a[99]-a[0]<=1) break;
				
				a[0]++;
				a[99]--;
				Arrays.sort(a);
			}
			
			System.out.printf("#%d %d%n",tc,a[99]-a[0]);
			
		}
		
	}
}
