import java.util.Scanner;

public class 기타리스트 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int[] vol = new int[N+1];
		for(int i=1;i<=N;i++) {
			vol[i] = sc.nextInt();
		}
		boolean[][] d = new boolean[N+1][M+1];
		d[0][S] = true;
		
		for(int i=0;i<=N-1;i++) {
			for(int j=0;j<=M;j++) {
				if(d[i][j]==false) continue;
				if(j-vol[i+1]>=0) d[i+1][j-vol[i+1]]=true;
				if(j+vol[i+1]<=M) d[i+1][j+vol[i+1]]=true;
			}
		}
		int ans = -1;
		for(int i=0;i<=M;i++)
			if(d[N][i]) ans = i;
		System.out.println(ans);
	}
}
