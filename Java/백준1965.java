import java.util.Scanner;

public class 백준1965 {
	
	static int[] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] d = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			d[i] = 1;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(arr[j]<arr[i]) {
					d[i]=Math.max(d	[i], d[j]+1);
				}
			}
		}
		int ans = -1;
		for(int i=0;i<n;i++) {
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}
}
