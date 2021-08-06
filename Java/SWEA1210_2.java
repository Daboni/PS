import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA1210_2 {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int mm = sc.nextInt();
			
			int des = 99;
			List<Integer> starts = new ArrayList<Integer>();
			int[][] map = new int[100][100];
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					map[i][j] = sc.nextInt();
					if(i==0 && map[i][j] == 1) starts.add(j); 
					if(map[i][j]==2) des = j; 
				}
			}
			int j =des;
			int ans = starts.indexOf(j);
			for(int i=99;i>=0;i--) {
				if(0<=j-1 && map[i][j-1]==1) {
					j=starts.get(ans-1);
					ans-=1;
				}
				else if(j+1<100 && map[i][j+1]==1) {
					j=starts.get(ans+1);
					ans+=1;
				}
			}
			System.out.printf("#%d %d%n",tc,starts.get(ans));
		}
		
	}
}

