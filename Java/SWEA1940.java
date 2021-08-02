import java.util.Scanner;

public class SWEA1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			
			int currentVel = 0;
			
			int ans = 0;
			for(int i=0;i<n;i++) {
				
				int c = sc.nextInt();
				
				if(c==0) {
					ans += currentVel;
					continue;
				}
				int v = sc.nextInt();

				if(c==1) {
					ans += (currentVel+v);
					currentVel += v;
				}
				if(c==2) {
					currentVel -= v;
					if(currentVel<0) currentVel=0;

					ans += (currentVel);
				}
			}
			System.out.printf("#%d %d%n",tc,ans);

		}
	}
}
