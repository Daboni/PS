import java.util.Scanner;

public class SWEA1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int mm = sc.nextInt();
			
			int des = 99;
			int[][] map = new int[100][100];
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]==2) des = j; 
				}
			}
			int j =des;
			for(int i=99;i>=0;i--) {
				if(0<=j-1 && map[i][j-1]==1) {
					int ny = j-1;
					while(true) {
						if(0 <=ny && map[i][ny]==1) {
							ny--;
							continue;
						}
						j=ny+1;
						break;
					}
				}
				else if(j+1<100 && map[i][j+1]==1) {
					int ny = j+1;
					while(true) {
						if(ny<100 && map[i][ny]==1) {
							ny++;
							continue;
						}
						j=ny-1;
						break;
					}
				}
				
			}
			System.out.printf("#%d %d%n",tc,j);
			
		}
	}
}
