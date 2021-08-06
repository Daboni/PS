import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SWEA4466 {
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
            int k = sc.nextInt();
            Integer[] a = new Integer[n];
            int ans = 0;
            for(int i =0 ;i<n;i++)	a[i] = sc.nextInt();
           	Arrays.sort(a,Collections.reverseOrder());
            for(int i=0;i<k;i++) ans+=a[i];
			System.out.printf("#%d %d%n",test_case,ans);
		}
	
	}
}
