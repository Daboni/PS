import java.util.Scanner;

public class SWEA1215 {
	
	public static boolean check(String s) {
		
		boolean ok = true;
		int n = s.length();
		for(int i=0;i<n/2;i++) {
			if(s.charAt(i)!=s.charAt(n-i-1)) {
				ok=false;
				break;
			}
		}
		return ok;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			char[][] a = new char[8][8];

			for (int i = 0; i < 8; i++) {
				String s = sc.next();
				for (int j = 0; j < 8; j++) {
					a[i][j] = s.charAt(j);
				}
			}
			int ans=0;
			for(int k=0;k<=8-n;k++) {
				for(int i=0;i<8;i++) {
					String s = "";
					for(int j=k;j<n+k;j++) {
						s+=a[i][j];
					}
					if(check(s)) ans+=1;
				}
			}
			
			for(int k=0;k<=8-n;k++) {
				for(int i=0;i<8;i++) {
					String s = "";
					for(int j=k;j<n+k;j++) {
						s+=a[j][i];
					}
					if(check(s)) ans+=1;
				}
			}
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
