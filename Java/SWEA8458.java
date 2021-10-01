import java.util.Scanner;

public class SWEA8458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			
			int[] point = new int[n];
			
			int max = 0;
			for(int i=0;i<n;i++) {
				point[i] = Math.abs(sc.nextInt());
				point[i] += Math.abs(sc.nextInt());
				max = Math.max(max, point[i]);
			}
			boolean isOK = true;
			
			int res = point[0]%2;
			for(int i=0;i<n;i++) {
				if(res!=point[i]%2) {
					isOK=false;
					break;
				}
			}
			int ans=0;
			int sum=0;
			if(isOK) {
				while(true) {
					if(sum%2==res && sum>=max) break;
					ans++;
					sum += ans;
				}
			}
			System.out.printf("#%d %d%n",tc,isOK==true?ans:-1);
		}
	}
}
