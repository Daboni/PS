import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA2676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String s = sc.next();
			int n = sc.nextInt();
			ArrayList<Character> arr = new ArrayList<Character>();
			int[] a = new int[n];
			for(int i=0;i<s.length();i++) {
				arr.add(s.charAt(i));
			}
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			for(int i=0;i<n;i++) {
				arr.add(a[i]+i,'-');
			}
			String ans="";
			for(char x:arr) {
				ans += x;
			}
			System.out.printf("#%d %s%n",tc,ans);
		}
	}
}
