import java.util.Scanner;


public class 백준11048 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n+1][m+1];
		int[][] d = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				
				d[i][j] = Math.max(Math.max(d[i-1][j-1]+map[i][j],d[i-1][j]+map[i][j]),d[i][j-1]+map[i][j]);

			}
		}
		System.out.println(d[n][m]);
	}
}
