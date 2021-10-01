import java.util.Scanner;

public class 백준11404 {
	public static int INF = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int m = sc.nextInt();
		
		int[][] map = new int[n+1][n+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				map[i][j] = INF;
			}
		}
		for(int i=0;i<m;i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			int c = sc.nextInt();
			
			map[s][d] = Math.min(map[s][d], c);
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				if(i==k) continue;
				for(int j=1;j<=n;j++) {
					if(i==j) continue;
					if(j==k) continue;
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j] == INF) System.out.print(0+" ");
				else System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
