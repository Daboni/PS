import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 백준16235 {
	static final int[] dx = {-1,-1,-1,0,0,1,1,1};
	static final int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[][] a = new int[n][n];
		int[][] d = new int[n][n];
		ArrayList<Integer>[][] tree = new ArrayList[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = sc.nextInt();
				d[i][j] = 5;
				tree[i][j] = new ArrayList<>();
			}
		}
		while(m-->0) {
			int x= sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
			tree[x-1][y-1].add(age);
		}
		while(k-->0) {
			int[][] p = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					ArrayList<Integer> temp = new ArrayList<>();
					Collections.sort(tree[i][j]);
					int dead=0;
					for(int x : tree[i][j]) {
						if(x<=d[i][j]) {
							d[i][j] -= x;
							temp.add(x+1);
							if((x+1)%5==0) {
								for(int s=0;s<8;s++) {
									int nx = i+dx[s];
									int ny = j+dy[s];
									if(0<=nx && nx<n && 0<=ny && ny<n) {
										p[nx][ny]++;
									}
								}
							}
						}
						else {
							dead += x/2;
						}
					}
					tree[i][j] = temp;
					d[i][j] += dead;
					d[i][j] += a[i][j];
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					for(int s=0;s<p[i][j];s++) {
						tree[i][j].add(1);
					}
				}
			}
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ans += (int)tree[i][j].size();
			}
		}
		System.out.println(ans);
	}
}
