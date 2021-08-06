import java.util.Scanner;

public class SWEA7532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int m = sc.nextInt();
			
			int i =0;
			int ans = 0;
			while(true) {
				int tmp = 365*i+s;
				if(tmp%24 == e%24 && tmp%29 == m%29) {
					ans = tmp;
					break;
				}
				i+=1;
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
