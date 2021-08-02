import java.util.Scanner;

public class SWEA1216 {
	
	public static boolean check(String str) {
		int n = str.length();
		
		boolean ok = true;
		for(int i=0;i<n/2;i++) {
			if(str.charAt(i)== str.charAt(n-i-1)) continue;
			ok = false;
		}
		return ok;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = 10;
		
		while(t-->0) {
			int tc = sc.nextInt();
			char[][] m = new char[100][100];
			
			for(int i=0;i<100;i++) {
				String s = sc.next();
				for(int j=0;j<100;j++) {
					m[i][j] = s.charAt(j);
				}
			}
			int ans = 1;
			for(int i=0;i<100;i++) {
				for(int k=2;k<=100;k++) {
					for(int s=0;s+k<=100;s++) {
						String str = "";
						for(int j=s;j<s+k;j++) {
							str+=m[i][j];
						}
						if(check(str)) ans = Math.max(ans, k);
					}
				}
			}
			for(int i=0;i<100;i++) {
				for(int k=2;k<=100;k++) {
					for(int s=0;s+k<=100;s++) {
						String str = "";
						for(int j=s;j<s+k;j++) {
							str+=m[j][i];
						}
						if(check(str)) ans = Math.max(ans, k);
					}
				}
			}
			
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
	
}
