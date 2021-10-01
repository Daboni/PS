import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준16235 {
	public static int[] dx = {1,1,0,-1,-1,-1,0,1};
	public static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	public static int[][] map;
	public static int[][] plusMap;
	public static ArrayList<tree>[][] d;
	public static int[] trees;
	
	public static class tree implements Comparable<tree>{
		int age;
		public tree(int age) {
			this.age =age;
		}
		@Override
		public int compareTo(tree o) {
			return Integer.compare(this.age, o.age);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		plusMap = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				plusMap[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		d = new ArrayList[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				d[i][j] = new ArrayList<>();
			}
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());

			d[x][y].add(new tree(age));

		}
		
		while(k-->0) {
			
			int[][] prodMap = new int[n][n];
			
			for(int x=0;x<n;x++) {
				for(int y=0;y<n;y++) {
					
					ArrayList<tree> tmp = d[x][y];
					Collections.sort(tmp);
					
					ArrayList<tree> tmp2 = new ArrayList<>();
					int dead = 0;
					for(tree tr : tmp) {
						if(tr.age<=map[x][y]) {
							map[x][y] -= tr.age;
							tmp2.add(new tree(tr.age+1));
							
							if((tr.age+1)%5 == 0) {
								
								for(int kk=0;kk<8;kk++) {
									int nx = x+dx[kk];
									int ny = y+dy[kk];
									
									if(nx<0||nx>=n||ny<0||ny>=n) continue;
									prodMap[nx][ny]+=1;
								}
							}
						}
						else dead += tr.age/2;
					}
					map[x][y] += dead;
					d[x][y] = tmp2;
					map[x][y] += plusMap[x][y];
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					for(int r=0;r<prodMap[i][j];r++) {
						d[i][j].add(new tree(1));
					}
				}
			}
		}
		int ans =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ans += d[i][j].size();
			}
		}
		System.out.println(ans);
	}
}
