import java.util.Arrays;
import java.util.Scanner;

public class SWEA7985 {
	public static int[] a;
	public static int n;
	public static int[] tree;
	public static int pow(int a, int b) {
		int k=1;
		for(int i=0;i<b;i++) {
			k*=a;
		}
		return k;
	}
	public static void go(int start, int end, int idx) {
		
		if(0 > start || start>n || 0 > end || end>n || idx>n) return;
		
		int mid = (start+end)/2;
		tree[idx-1] = a[mid];
		if(start==end) return;
		go(start,mid-1,2*idx);
		go(mid+1,end,2*idx+1);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int k = sc.nextInt();
			n = pow(2,k)-1;
			a = new int[n];
			tree = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			
			go(0,n,1);
			System.out.printf("#%d ",tc);
			for(int i=1;i<n;i*=2) {
				for(int j=i-1;j<i+i-1;j++) {
					System.out.printf("%d ",tree[j]);					
				}
				System.out.println();
			}
		}
		
	}
}
