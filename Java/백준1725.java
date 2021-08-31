import java.util.Scanner;
import java.util.Stack;

public class 백준1725 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Integer> s = new Stack<>();

		int n = sc.nextInt();
		int[] a = new int[n+1];
		
		for(int i=1;i<=n;i++) a[i] = sc.nextInt();
		s.push(0);
		int ans = 0;
		for (int i = 1; i <= n+1; i++) {

			while (!s.isEmpty() && a[s.peek()] > a[i]) {
				int check = s.peek();
				s.pop();
				ans = Math.max(ans, a[check]*(i-s.peek()-1));
			}
			s.push(i);
		}
		System.out.println(ans);
	}
}
