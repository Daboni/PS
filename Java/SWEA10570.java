import java.util.ArrayList;
import java.util.Scanner;

public class SWEA10570 {
	
	public static boolean ok(int n) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		while(n>0) {
			a.add(n%10);
			n/=10;
		}
		boolean isTrue = true;
		for(int i=0;i<a.size()/2;i++) {
			if(a.get(i)!=a.get(a.size()-i-1)) {
				isTrue = false;
				break;
			}
		}
		return isTrue;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int ans = 0;
			for(int i=a;i<=b;i++) {
				if(ok(i)) {
					int tmp =1 ;
					int s = 0;
					while(true) {
						if(tmp*tmp==i) {
							s=tmp;
							break;
						}
						if(tmp*tmp>i) break;
						tmp+=1;
					}
					if(s!=0) {
						if(ok(s)) ans+=1;
					}
				}
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
