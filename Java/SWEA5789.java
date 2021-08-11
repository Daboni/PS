import java.util.Scanner;

public class SWEA5789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			
			int[] a = new int[n+1];
			for(int i=1;i<=q;i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				for(int k=l;k<=r;k++) {
					a[k] = i;
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=1;i<a.length;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
	}
}
