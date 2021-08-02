import java.util.Scanner;

public class 백준9252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int n = a.length();
		int m = b.length();
		a = " "+a;
		b = " "+b;
		
		int[][] c = new int[n+1][m+1];
		int[][] d = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(a.charAt(i)==b.charAt(j)) {
					c[i][j] = c[i-1][j-1]+1;
					d[i][j] = 1;
				}
				else {
					if(c[i][j-1]>c[i-1][j]) {
						c[i][j] = c[i][j-1];
						d[i][j] = 2;
					}
					else {
						c[i][j] = c[i-1][j];
						d[i][j] = 3;
					}
				}
			}
		}
		String ans = "";
		while(n>0 && m>0) {
			if(d[n][m]==1) {
				ans+=a.charAt(n);
				n--; m--;
			}
			else if(d[n][m]==2) {
				m--;
			}
			else {
				n--;
			}
		}
		System.out.println(ans.length());
		System.out.println(new StringBuilder(ans).reverse().toString());
	}
}
