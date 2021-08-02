import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA7102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] d = new int[n + m + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					d[i + j]++;
				}
			}
			List<Integer> ans = new ArrayList<Integer>();
			ans.add(0);
			for (int i = 1; i <= n + m; i++) {
				if (d[ans.get(0)] < d[i]) {
					ans.clear();
					ans.add(i);
				}
				else if(d[ans.get(0)]==d[i]) ans.add(i); 
			}
			System.out.printf("#%d ",tc);

			for(int x:ans){
				System.out.printf("%d ",x);
			}
			System.out.println();
		}
	}
}
