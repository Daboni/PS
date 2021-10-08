import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1949 {
	public static int T, N, K, max, res;
	public static int arr[][];
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static Queue<int[]> q = new LinkedList<>();
	public static Queue<int[][]> visited = new LinkedList<>();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt(); K = sc.nextInt();
			arr = new int[N][N];
			max = 0; res = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					max = Math.max(max, arr[i][j]); 
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == max) { 
						int tmp[][] = new int[N][N]; tmp[i][j] = 1; 
						q.offer(new int[] {i, j, 0, 1, arr[i][j]});
						visited.offer(tmp);
						bfs();
					}
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			
			for(int k = 0; k < 4; k++) {
				int nx = q.peek()[0] + dx[k];
				int ny = q.peek()[1] + dy[k];
				int chk = q.peek()[2];
				int depth = q.peek()[3];
				int height = q.peek()[4];
				int tmp[][] = new int[N][N];
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						tmp[i][j] = visited.peek()[i][j];
					}
				}
				if(isRange(nx,ny) && tmp[nx][ny]!=1) {
					
					if(arr[nx][ny] < height) { 
						q.offer(new int[] {nx, ny, chk, depth + 1, arr[nx][ny]}); 
					}
					else if(chk == 0 && K >= arr[nx][ny] - height + 1) {
						q.offer(new int[] {nx, ny, 1, depth + 1, height - 1}); 
					}
					else continue;
					
					tmp[nx][ny] = 1; 		
					visited.offer(tmp); 
				}
				
			}
			res = Math.max(res, q.poll()[3]); 
			visited.poll();
		}
	}
	public static boolean isRange(int nx,int ny) {
		if(nx<0||nx>=N||ny<0||ny>=N) return false;
		return true;
	}
}