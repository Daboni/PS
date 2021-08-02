import java.util.Scanner;

public class SWEA2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int n = sc.nextInt();
            int[][] m = new int[n][n];
            m[0][0] = 1;
            for(int i=1;i<n;i++){
            	for(int j=0;j<n;j++){
                	if(j==0) {
                        m[i][j]=1;
                        continue;
                    }
                    if(j==i){
                        m[i][j]=1;
                        break;
                    }
                    m[i][j]=m[i-1][j-1]+m[i-1][j];
                }
            }
            System.out.printf("#%d%n",test_case);
			for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    System.out.print(m[i][j]+" " );
                }
                System.out.println();
			}
        }
	}
}
