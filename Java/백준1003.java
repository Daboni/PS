import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준1003 {
	
	static int[] d0 = new int[41];
	static int[] d1 = new int[41];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		d0[0] = 1;
		d1[0] = 0;
		
		d0[1] = 0;
		d1[1] = 1;
		for(int i=2;i<=40;i++) {
			d0[i] = d0[i-1] + d0[i-2];
			d1[i] = d1[i-1] + d1[i-2];
		}
		int T = Integer.parseInt(in.readLine());
			
		while(T-->0) {
			int n = Integer.parseInt(in.readLine());
			System.out.println(d0[n]+" "+d1[n]);
		}
	}
}
