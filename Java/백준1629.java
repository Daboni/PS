    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준1629 {
	
	static int n;
	static int m;
	static int c;
	
	public static long go(int a, int k,int c) {
		if(k==1) return n;
		long d = go(a,k/2,c);
		if(k%2==0) {
			return d*d%c;
		}
		else {
			return d*d*n%c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		long ans = go(n,m,c);
		System.out.println(ans);
		
	}
}
