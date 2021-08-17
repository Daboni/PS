import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1074v2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int cnt=0;
		int x=0,y=0;
		int size = (1<<n);
		while(n-->0) {
			
			if(r<x+size/2 && c<y+size/2) {
				size /= 2;
				continue;
			}
			if(r<x+size/2 && c>=y+size/2) {
				size/=2;
				y=y+size;
				cnt += size*size;
				continue;
			}
			if(r>=x+size/2 && c<y+size/2) {
				size/=2;
				x=x+size;
				cnt += size*size*2;
				continue;
			}
			if(r>=x+size/2 && c>=y+size/2) {
				size/=2;
				x=x+size;
				y=y+size;
				cnt += size*size*3;
				continue;
			}
		}
		System.out.println(cnt);
	}
}
