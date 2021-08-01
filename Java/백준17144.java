import java.util.Scanner;

public class 백준17144 {
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		int airx1=-1;int airy1=-1;
		int airx2=0;int airy2=0;
		int[][] map = new int[n][m];
		int[][] d = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				d[i][j] = map[i][j];
				if(map[i][j] == -1) {
					if(airx1 == -1) {
						airx1 = i; airy1 =j;
					}
					else {
						airx2 = i; airy2 =j;
					}
				}
			}
		}
		while(t-->0) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]!=0 && map[i][j]!=-1) {
						int tmp = map[i][j]/5;
						for(int k=0;k<4;k++) {
							int nx = i+dx[k];
							int ny = j+dy[k];
							if(0<=nx&&nx<n&&0<=ny&&ny<m&&map[nx][ny]!=-1) {
								d[nx][ny]+=tmp;
								d[i][j] -= tmp;
							}
						}
					}
				}
			}
			for(int nx=airx1-1;nx>=0;nx--) {
				if(d[nx][0] != 0) {
					if(d[nx+1][0]==-1) d[nx][0]=0;
					else{
						d[nx+1][0] = d[nx][0];
						d[nx][0] = 0;
					}
				}
			}
			for(int ny=airy1+1;ny<m;ny++) {
				if(d[0][ny] != 0) {
					if(d[0][ny-1]==-1) d[0][ny]=0;
					else {
						d[0][ny-1] = d[0][ny];
						d[0][ny] = 0;
					}
				}
			}
			for(int nx=1;nx<=airx1;nx++) {
				if(d[nx][m-1] != 0) {
					d[nx-1][m-1] = d[nx][m-1];
					d[nx][m-1] = 0;					
				}
			}
			for(int ny=m-2;ny>0;ny--) {
				if(d[airx1][ny] != 0) {
					d[airx1][ny+1] = d[airx1][ny];
					d[airx1][ny] = 0;
				}
			}
			/////////////////////////////////////
			for(int nx=airx2+1;nx<n;nx++) {
				if(d[nx][0] != 0) {
					if(d[nx-1][0]==-1) d[nx][0]=0;
					else{
						d[nx-1][0] = d[nx][0];
						d[nx][0] = 0;
					}
				}
			}
			for(int ny=1;ny<m;ny++) {
				if(d[n-1][ny]!=0) {
					if(d[n-1][ny-1]==-1) d[n-1][ny] =0;
					else {
						d[n-1][ny-1] = d[n-1][ny];
						d[n-1][ny] = 0;
					}
				}
			}
			for(int nx=n-2;nx>=airx2;nx--) {
				if(d[nx][m-1] != 0) {
					d[nx+1][m-1] = d[nx][m-1];
					d[nx][m-1] = 0;
				}
			}
			for(int ny=m-2;ny>0;ny--) {
				if(d[airx2][ny] != 0) {
					d[airx2][ny+1] = d[airx2][ny];
					d[airx2][ny] = 0;
				}
			}
			for(int i=0;i<n;i++) {
				for(int j =0;j<m;j++) {
					map[i][j]=d[i][j];
				}
			}
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			for(int x:map[i]) {
				if(x==-1 || x==0) continue;
				ans+=x;
			}
		}
		System.out.println(ans);
	}
}
