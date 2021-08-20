import java.util.Scanner;

public class SWEA1493 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			int n=0;
			while(true) {
				if(n*(n+1)/2>=a) break;
				n++;
			}
			n-=1;
			int x1 = 1;
			int y1 = n+1;
			
			int tmp = n*(n+1)/2+1;
			while(true) {
				if(tmp==a) break;
				tmp++;
				x1++;
				y1--;
			}
			int m=0;
			while(true) {
				if(m*(m+1)/2>=b) break;
				m++;
			}
			m-=1;
			int x2 = 1;
			int y2 = m+1;
			tmp = m*(m+1)/2+1;
			while(true) {
				if(tmp==b) break;
				tmp++;
				x2++;
				y2--;
			}
//			if(a==1) {
//				x1=1;
//				y1=1;
//			}
//			if(b==1) {
//				x2=1;
//				y2=1;
//			}
			int nx = x1+x2;
			int ny = y1+y2;
			
			int ans = 1;
			lable1:for(int i=1;;i++) {
				for(int j=1,k=i;j<=i;j++,k--) {
					if(j==nx && k==ny) {
						System.out.println("#"+tc+" "+ans);
						break lable1;
					}
					ans++;
				}
			}
		}
	}
}
