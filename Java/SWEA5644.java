import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5644 {
	public static int[] dx = { 0, -1, 0, 1, 0 };
	public static int[] dy = { 0, 0, 1, 0, -1 };

	public final static int SIZE = 10;

	public static int n;
	public static int m;

	public static ArrayList<Integer>[][] map;

	public static int[] moveA;
	public static int[] moveB;
	public static BC[] bcs;
	public static int[][][] b;

	public static int[][] ans;

	public static class BC implements Comparable<BC> {
		int no;
		int x;
		int y;
		int range;
		int power;

		public BC(int no, int x, int y, int range, int power) {
			this.no = no;
			this.x = x;
			this.y = y;
			this.range = range;
			this.power = power;
		}

		@Override
		public int compareTo(BC o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.power, this.power);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			moveA = new int[n];
			moveB = new int[n];

			map = new ArrayList[SIZE][SIZE];

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			bcs = new BC[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				bcs[i] = new BC(i, x, y, range, power);
				map[x][y].add(i);

			}
			b = new int[SIZE][SIZE][m];

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					for (int x : map[i][j]) {
						if (b[i][j][x] == 0)
							bfs(i, j, x);
					}
				}
			}
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (map[i][j].size() > 1)
						sortBC(i, j);
				}
			}

			ans = new int[2][n+1];
			go();
			int res = 0;
			for (int i = 0; i <= n; i++) {
				res += ans[0][i];
				res += ans[1][i];
			}
			System.out.println(res);
		}
	}

	public static void bfs(int sx, int sy, int bcNum) {

		Queue<int[]> q = new LinkedList<>();

		b[sx][sy][bcNum] = 0;

		q.add(new int[] { sx, sy });

		while (!q.isEmpty()) {

			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];

			if (b[x][y][bcNum] == bcs[bcNum].range)
				break;
			for (int k = 1; k < 5; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (isRange(nx, ny)) {
					if (!map[nx][ny].contains(bcNum)) {
						q.add(new int[] { nx, ny });
						map[nx][ny].add(bcNum);
						b[nx][ny][bcNum] = b[x][y][bcNum] + 1;
					}
				}
			}

		}

	}

	public static boolean isRange(int nx, int ny) {
		if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE)
			return false;
		return true;
	}

	public static void go() {

		int anx = 0, any = 0;
		int bnx = 9, bny = 9;

		if (map[anx][any].size() != 0) {
			ans[0][0] = bcs[map[anx][any].get(0)].power;
		}
		if (map[bnx][bny].size() != 0) {
			ans[1][0] = bcs[map[bnx][bny].get(0)].power;
		}
		for (int i = 0, j = 1; i < n; i++, j++) {
			anx = anx + dx[moveA[i]];
			any = any + dy[moveA[i]];
			bnx = bnx + dx[moveB[i]];
			bny = bny + dy[moveB[i]];
			
			if(map[anx][any].size() != 0 && map[bnx][bny].size() == 0) {
				ans[0][j] = bcs[map[anx][any].get(0)].power;
			}
			if(map[anx][any].size() == 0 && map[bnx][bny].size() != 0) {
				ans[1][j] = bcs[map[bnx][bny].get(0)].power;
			}
			if (map[anx][any].size() != 0 && map[bnx][bny].size() != 0) {

				if (map[anx][any].get(0) == map[bnx][bny].get(0)) {
					if (map[anx][any].size() == 1 && map[bnx][bny].size() == 1) {
						ans[0][j] = bcs[map[anx][any].get(0)].power / 2;
						ans[1][j] = bcs[map[bnx][bny].get(0)].power / 2;
					} else if (map[anx][any].size() == 1 && map[bnx][bny].size() > 1) {
						ans[0][j] = bcs[map[anx][any].get(0)].power;
						ans[1][j] = bcs[map[bnx][bny].get(1)].power;
						
					} else if (map[anx][any].size() > 1 && map[bnx][bny].size() == 1) {
						ans[0][j] = bcs[map[anx][any].get(1)].power;
						ans[1][j] = bcs[map[bnx][bny].get(0)].power;
						
					} else if (map[anx][any].size() > 1 && map[bnx][bny].size() > 1) {
						if (bcs[map[anx][any].get(0)].power
								+ bcs[map[bnx][bny].get(1)].power > bcs[map[anx][any].get(1)].power
										+ bcs[map[bnx][bny].get(0)].power) {
							ans[0][j] = bcs[map[anx][any].get(0)].power;
							ans[1][j] = bcs[map[bnx][bny].get(1)].power;
						} else {
							ans[0][j] = bcs[map[anx][any].get(1)].power;
							ans[1][j] = bcs[map[bnx][bny].get(0)].power;
						}
					}
				} else {
						ans[0][j] = bcs[map[anx][any].get(0)].power;
						ans[1][j] = bcs[map[bnx][bny].get(0)].power;
				}
			}
		}
	}

	public static void sortBC(int x, int y) {

		PriorityQueue<BC> pq = new PriorityQueue<>();

		for (int bc : map[x][y]) {
			pq.add(bcs[bc]);
		}

		ArrayList<Integer> tmp = new ArrayList<>();
		while (!pq.isEmpty())
			tmp.add(pq.poll().no);
		
		map[x][y] = tmp;
	}
}
