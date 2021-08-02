import java.util.*;

public class 로봇청소 {
	public static void main(String[] args) {
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n][m];

		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		int isCom = 0;
		while(true) {
			// 1.
			if(map[r][c]==0) {
				isCom = 0;
				ans++;
				map[r][c]=2;
				continue;
			}
			
			
			//2
			if(0<=r+dx[(d+3)%4]&&r+dx[(d+3)%4]<n&&0<=c+dy[(d+3)%4]&&c+dy[(d+3)%4]<m && map[r+dx[(d+3)%4]][c+dy[(d+3)%4]]==0) {
				d=(d+3)%4;
				r = r+dx[d];
				c = c+dy[d];
				continue;
				
			}
				//3
			else {
				if(isCom!=4) {
					d=(d+3)%4;
						isCom++;
						continue;
					}
					else if(isCom==4) {
						if(map[r+dx[(d+2)%4]][c+dy[(d+2)%4]]!=1) {
								r=r+dx[(d+2)%4];
								c=c+dy[(d+2)%4];
								isCom=0;
								continue;
						}
						
						else break;
				}
			}
			
			
		}
		System.out.println(ans);
	}
}
