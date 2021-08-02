import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA11688 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int a = 1;
			int b = 1;
			String s = in.readLine();
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				if(c=='L') {
					b=a+b;
				}
				else {
					a=a+b;
				}
			}
			System.out.printf("#%d %d %d%n",tc,a,b);
		}
		
	}
}
