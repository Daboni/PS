import java.util.Scanner;

public class 백준2096 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] map = new int[n+1][3];
		
		int[][] maxd = new int[n+1][3];
		int[][] mind = new int[n+1][3];
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<3;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1;i<=n;i++) {
			
			for(int j=0;j<3;j++) {
				if (j==0) {
					maxd[i][j] = Math.max(maxd[i-1][j], maxd[i-1][j+1]) + map[i][j];
					mind[i][j] = Math.min(mind[i-1][j], mind[i-1][j+1]) + map[i][j];
					
				}
				if(j==1) {
					maxd[i][j] = Math.max(Math.max(maxd[i-1][j-1], maxd[i-1][j]),maxd[i-1][j+1]) + map[i][j];
					mind[i][j] = Math.min(Math.min(mind[i-1][j-1], mind[i-1][j]),mind[i-1][j+1]) + map[i][j];
				}
				if(j==2) {
					maxd[i][j] = Math.max(maxd[i-1][j], maxd[i-1][j-1]) + map[i][j];
					mind[i][j] = Math.min(mind[i-1][j], mind[i-1][j-1]) + map[i][j];
				}
			}
			
		}
		int min = 123456789;
		int max = -123456789;
		for(int i=0;i<3;i++) {
			min = Math.min(min, mind[n][i]);
			max = Math.max(max, maxd[n][i]);
		}
		System.out.println(max +" " + min);
	}
}
