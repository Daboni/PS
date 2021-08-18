import java.util.Scanner;

public class 백준4936v2 {
	static int[][] map;
	static int H, W;
	
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();
			if (W == 0 && H == 0)
				break;

			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int cnt=0;
			//탐색하면서 육지인 경우 카운트를 하나 세고 연결된 모든 육지를 삭제
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]==1) {
						cnt++;
						dfs(i,j);
						//연결된 모든 육지 0으로 삭제
					}
				}
			}
			System.out.println(cnt);
		}
	}
	static void dfs(int r,int c) {
		//현재 육지 삭제
		map[r][c] = 0;
		//8방에 대해서 지도 밖이면 패스 바다여도 패스
		//육지라면 재귀 콜
		for(int k=0;k<8;k++) {
			int nx = r+dx[k];
			int ny = c+dy[k];
			if(nx<0 || nx>=H || ny <0 || ny>=W || map[nx][ny] == 0)
				continue;
			dfs(nx,ny);
		}
	}
}
