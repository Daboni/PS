import java.util.Arrays;
import java.util.Scanner;

public class 백준3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)  a[i] = sc.nextInt();
		int x = sc.nextInt();
		
		int start = 0;
		int end = n-1;
		int ans=0;
		int sum=0;
		
		Arrays.sort(a);
		
		while(start<=end) {
			sum = a[start]+a[end];
			if(sum==x) {
				ans++;
			}
			if(sum>x) {
				end--;
			}
			else if(sum<=x){
				start++;
			}
		}
		System.out.println(ans);
	}
}
