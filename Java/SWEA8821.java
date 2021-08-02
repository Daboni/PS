import java.util.Scanner;

public class SWEA8821 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String s = sc.next();
			char[] m = s.toCharArray();
            int[] d = new int[10];
            for(int i=0;i<m.length;i++) {
            	int n = m[i]-'0';
            	if(d[n]==0) d[n]++;
            	else d[n]--;
            }
            int ans = 0;
			for(int x : d){
            	if(x==1) ans++;
            }
			
            System.out.printf("#%d %d%n",test_case,ans);
		}
	}
}
