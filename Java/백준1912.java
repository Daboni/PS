import java.util.Scanner;

public class 백준1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		int[] d= new int[n];
		d[0] = a[0];
		
		for(int i=1;i<n;i++) {
			d[i] = Math.max(d[i-1]+a[i],a[i]);
			
		}
		int max=-123456789;
		for(int i=0;i<n;i++) {
			max = Math.max(max, d[i]);
		}
		System.out.println(max);
	}
}
