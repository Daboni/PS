import java.util.Scanner;

public class SWEA1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			
			int[][] m = new int[9][9];
			
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
					m[i][j] = sc.nextInt();
			
			boolean isTrue = true;
			
			label1: for(int i=0;i<9;i++) {
				int[] d = new int[10];
				for(int j=0;j<9;j++) {
					if(d[m[i][j]]==0) d[m[i][j]]++;
					else if(d[m[i][j]]==1) {
						isTrue = false;
						break label1;
					}
				}
			}

			label2: for(int i=0;i<9;i++) {
				if(!isTrue) break;
				int[] d = new int[10];
				for(int j=0;j<9;j++) {
					if(d[m[j][i]]==0) d[m[j][i]]++;
					else if(d[m[j][i]]==1) {
						isTrue = false;
						break label2;
					}
				}
			}
	
			label3: for(int s=0;s<9;s+=3) {
				if(!isTrue) break;
				for(int k=0;k<9;k+=3) {
					int[] d = new int[10];
					for(int i=s;i<s+3;i++) {
						for(int j=k;j<k+3;j++) {
							if(d[m[i][j]]==0) d[m[i][j]]++;
							else if(d[m[i][j]]==1) {
								isTrue = false;
								break label3;
							}
						}
					}
				}
			}
			if(!isTrue) 
				System.out.printf("#%d %d%n",tc,0);
			else 
				System.out.printf("#%d %d%n",tc,1);
			 
		}
	}
}
