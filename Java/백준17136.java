import java.util.Scanner;

public class 백준17136 {
	static int n = 10;
	static int[][] map = new int[n][n];
	static int[] paper = { 5, 5, 5, 5, 5 };
	static int ans=987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		go(0,0,0);

		System.out.println(ans!=987654321?ans:-1);
	}

	public static void go(int r, int c, int cnt) {

		if(r>=n-1 && c>n-1) {
			ans = Math.min(ans,cnt);
			return;
		}
		if(ans<=cnt) return;
		
		if(c>n-1) {
			go(r+1,0,cnt);
			return;
		}
		
		if(map[r][c]==1) {
			
			for (int k = 5; k >= 1; k--) {
				int s = 0;
				if (r + k <= n && c + k <= n) {
					for (int i = 0; i < k; i++) {
						for (int j = 0; j < k; j++) {
							s += map[r + i][c + j];
						}
					}
					
					if (s == k * k && paper[k-1]>0) {
						paper[k-1]--;
						for (int i = 0; i < k; i++) {
							for (int j = 0; j < k; j++) {
								map[r + i][c + j] = 0;
							}
						}
						
						go(r, c+1,cnt+1);
						
						paper[k-1]++;
						
						for (int i = 0; i < k; i++) {
							for (int j = 0; j < k; j++) {
								map[r + i][c + j] = 1;
							}
						}
					}
					
				}
			}
		}else {
			go(r,c+1,cnt);
		}
	}

}
