import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class piece{
	int no;
	int dir;
	piece(int no,int dir){
		this.no = no;
		this.dir = dir;
	}
}
class Pair3{
	int row,col;
	Pair3(int row,int col){
		this.row = row;
		this.col = col;
	}
}

public class 백준17780 {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int opposite(int dir) {
		if(dir==0) return 1;
		if(dir==1) return 0;
		if(dir==2) return 3;
		return 2;
	}
	static void go(ArrayList<piece>[][] a,Pair3[] where,int x,int y, int nx,int ny) {
		for(piece p : a[x][y]) {
			a[nx][ny].add(p);
			where[p.no] = new Pair3(nx,ny);
		}
		a[x][y].clear();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] board= new int[n][n];

		ArrayList<piece>[][] a = new ArrayList[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = new ArrayList<>();
				board[i][j] = sc.nextInt();
			}
		}
		Pair3[] where = new Pair3[m];
		for (int i=0; i<m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int dir = sc.nextInt()-1;
            a[x][y].add(new piece(i, dir));
            where[i] = new Pair3(x, y);
        }
		 for (int turn=1; turn<=1000; turn++) {
	            for (int k=0; k<m; k++) {
	                int x = where[k].row;
	                int y = where[k].col;
	                if (a[x][y].get(0).no == k) { // bottom
	                    int dir = a[x][y].get(0).dir;
	                    int nx = x+dx[dir];
	                    int ny = y+dy[dir];
	                    if (0 <= nx && nx < n && 0 <= ny && ny < n) { // in
	                        if (board[nx][ny] == 2) {
	                            a[x][y].get(0).dir = opposite(dir);
	                        }
	                    } else {
	                        a[x][y].get(0).dir = opposite(dir);
	                    }
	                    dir = a[x][y].get(0).dir;
	                    nx = x+dx[dir];
	                    ny = y+dy[dir];
	                    if (0 <= nx && nx < n && 0 <= ny && ny < n) { // in
	                        if (board[nx][ny] == 0) {
	                            go(a, where, x, y, nx, ny);
	                        } else if (board[nx][ny] == 1) {
	                            Collections.reverse(a[x][y]);
	                            go(a, where, x, y, nx, ny);
	                        }
	                        if (a[nx][ny].size() >= 4) {
	                            System.out.println(turn);
	                            System.exit(0);
	                        }
	                    } else { // out
	                    }
	                }
	            }
	        }
	        System.out.println(-1);
	    
	}
}
