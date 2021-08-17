import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백준1074 {
	static int cnt;
	static int r,c;
	static void go(int size, int n,int sx, int sy) throws IOException {
		if (n == 0) {
			if(sx == r && sy == c) {
				StringBuilder sb = new StringBuilder();
				sb.append(cnt);
				bw.write(sb.toString());
				bw.flush();
				System.exit(0);
			}
			cnt++;
			return;
		}
		
		if(r < sx+size/2 && c < sy+size/2) {
			go(size/2,n-1,sx,sy);
			return;
		}
		if(r < sx+size/2 && sy+size/2 <= c	) {
			cnt+= (size/2)*(size/2);
			go(size/2,n-1,sx,sy+size/2);
			return;
		}
		if( sx+size/2 <= r && c < sy+size/2) {
			cnt+= (size/2)*(size/2)*2;
			go(size/2,n-1,sx+size/2,sy);
			return;
		}
		if(r >= sx+size/2 && c >= sy+size/2) {
			cnt += (size/2)*(size/2)*3;
			go(size/2,n-1,sx+size/2,sy+size/2);
			return;
		}
		
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int sz = (int)(Math.pow(2, n));
		go(sz,n,0,0);
		
		
	}
}
