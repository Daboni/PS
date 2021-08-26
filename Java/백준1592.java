import java.util.Scanner;

public class 백준1592{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		
		int[] a = new int[n];
		int cnt = 0;
		int cur = 0;
		a[cur]=1;
		while(true) {
			
			if(a[cur]%2==0) {
				cur = (cur-l+n)%n;				
			}
			else {
				cur = (cur+l)%n;
			}
			cnt++;
			if(++a[cur]==m) break;
		}
		System.out.println(cnt);
	}
}
