import java.util.Scanner;

public class SWEA1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int n = sc.nextInt();
			
			int[] a = new int[n];
			
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			int ans = 0;
			for(int i=0;i<n;i++) {
				if(a[i]==0) continue;
				int tmp = 255000;
				for(int k=-2;k<3;k++) {
					int nx = i+k;
					if(0<=nx && nx<n) {
						if(nx==i) continue;
						if(a[i]-a[nx]>0) tmp = Math.min(tmp, a[i]-a[nx]);
						else {
							tmp = 0;
							break;
						}
					}
					
				}
				ans += tmp;
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
		
	}
}
