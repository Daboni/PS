import java.util.Scanner;

public class 백준9663 {
	static int n;
	static int[][] a;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		a = new int[n][n];

		go(0);
		System.out.println(cnt);
	}

	public static void go(int idx) {

		if (idx == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isOk(idx, i))
				continue;

			a[idx][i] = 1;
			go(idx + 1);
			a[idx][i] = 0;

		}
	}

	public static boolean isOk(int r, int c) {

		for (int i = r; i >= 0; i--) {
			if (a[i][c] == 1)
				return false;
		}
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (a[i][j] == 1)
				return false;
		}
		for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
			if (a[i][j] == 1)
				return false;
		}
		return true;
	}
}
