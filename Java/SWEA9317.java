import java.util.Scanner;

public class SWEA9317 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			String s1 = sc.next();
			String s2 = sc.next();
			int ans=0;
			for(int i=0;i<n;i++) {
				if(s1.charAt(i) == s2.charAt(i)) ans++;
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
