import java.util.*;

public class 백준9251 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int n = a.length();
		int m = b.length();
		a = " "+a;
		b = " "+b;
		int[][] c = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(a.charAt(i)==b.charAt(j))
					c[i][j] = c[i-1][j-1]+1;
				else
					c[i][j] = Math.max(c[i][j-1],c[i-1][j]);
			}
		}
		System.out.println(c[n][m]);
	}
}
