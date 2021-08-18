import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준4963 {
	
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	static int H,W;
	static int[][] map;
	static int[][] d;
	static int cnt;
	public static void bfs(int sx, int sy) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {sx,sy});
		d[sx][sy]= ++cnt;
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int k=0;k<8;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx<0 || nx >= H || ny <0 || ny>=W || map[nx][ny] == 0) continue;
				if(d[nx][ny] != 0) continue;
				d[nx][ny] = cnt;
				q.add(new int[] {nx,ny});
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			
			W = sc.nextInt();
			H = sc.nextInt();
			if (W == 0 && H == 0)
				break;

			map = new int[H][W];
			d = new int[H][W];
			cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//탐색하면서 육지인 경우 카운트를 하나 세고 연결된 모든 육지를 삭제
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]==1 && d[i][j] == 0) {
						bfs(i,j);
						//연결된 모든 육지 0으로 삭제
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
