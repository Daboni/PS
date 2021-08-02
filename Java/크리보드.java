import java.util.*;

public class 크리보드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[] d = new long[n+1];
		
		for(int i=1;i<=n;i++){
			d[i] = d[i-1]+1;
			for(int j=1;j<=i-2;j++) {
				d[i] = Math.max(d[i], d[i-(j+2)]*(j+1));
			}
		}
		System.out.println(d[n]);
	}
}
