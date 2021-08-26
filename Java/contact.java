import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class contact {
	static int n;
	static int[][] map;
	static int[] d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			n = sc.nextInt();
			map = new int[101][101];
			d = new int[101];
			int start = sc.nextInt();
			for (int i = 0; i < n/2; i++) {
				map[sc.nextInt()][sc.nextInt()]=1;
			}

			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(start);
			d[start] = 1;

			while (!q.isEmpty()) {

				int cur = q.poll();
				for (int i = 0; i < map[cur].length;i++) {
					if (map[cur][i]==1 && d[i] == 0) {
						q.offer(i);
						d[i] = d[cur] + 1;
					}
				}

			}
			int max =0;
			for(int i=0;i<=100;i++) {
				if(d[i]>=d[max]) max=i;
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
