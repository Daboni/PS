import java.util.Scanner;

public class 간단한369게임 {
	
	static int go(int num) {
		
		if(num<=0) return 0;
		
		int ans = 0;
		
		if(num%10==3||num%10==6||num%10==9) ans+=1;
		ans += go(num/=10);
		return ans;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			
			int cnt = go(i);
			if(cnt>0) {
				for(int k =0;k<cnt;k++)
					System.out.print("-");
				System.out.print(" ");
			}
			else System.out.print(i+" ");
		}
	}
}
