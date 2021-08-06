	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Scanner;
	import java.util.StringTokenizer;
	
	public class SWEA5162 {
		
		public static int k;
		public static int n;
		public static int m;
		
		public static int ans=0;
		
		public static void go(int cur,int cnt) {
			
			if(cur>k) return;
			ans = Math.max(ans, cnt);
			go(cur+n, cnt+1);
			go(cur+m ,cnt+1);
		}
		
		public static void main(String[] args) throws NumberFormatException, IOException {
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				int T = Integer.parseInt(sc.readLine());
				
				for(int tc=1;tc<=T;tc++) {
					
					StringTokenizer st = new StringTokenizer(sc.readLine()," ");
					
					
					n = Integer.parseInt(st.nextToken());
					m = Integer.parseInt(st.nextToken());
					k = Integer.parseInt(st.nextToken());
					
					ans = k/Math.min(n, m);
					
					System.out.printf("#%d %d%n",tc,ans);
				}
				
		}
	}
