import java.util.Scanner;

public class SWEA1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int t = sc.nextInt();
			String s1 = sc.next();
			String s2 = sc.next();
			
			int idx=0;
			int ans=0;
			while(true) {
				idx = s2.indexOf(s1,idx+1);
				if(idx == -1) break;
				ans++;
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
