import java.util.Scanner;

public class SWEA1948 {
	public static void main(String[] args) {
		
		int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++) {
			int startMonth = sc.nextInt();
			int startDay = sc.nextInt();
			int endMonth = sc.nextInt();
			int endDay = sc.nextInt();
			
			int ans = 0;
			for(int i=startMonth;i<endMonth;i++) {
				ans += days[i];
			}
			ans -= startDay;
			ans += endDay;
			
			System.out.printf("#%d %d%n",tc,ans+1);
		}
	}
}
