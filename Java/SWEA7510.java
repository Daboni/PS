import java.util.Scanner;

public class SWEA7510 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			
			// N = x + (x+1) + (x+2)... + (x+y)
			// x = (N-y(y+1))/2(y+1)
			
			int ans = 1;
			for(int y=1;y<=N;y++) {
				int x = (N-y*(y+1)/2);
				int k = (y+1);
				if(x<=0) break;
				
				if(x%k==0) ans++;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
