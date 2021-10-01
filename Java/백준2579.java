import java.util.Scanner;

public class 백준2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] map = new int[n+1];
		int[] d = new int[n+1];
		for(int i=1;i<=n;i++) {
			map[i] = sc.nextInt();
		}
		d[1] = map[1];
		for(int i=2;i<=n;i++) {
			
			if(i==2) {
				d[i] = d[i-1]+map[i];
				continue;
			}
			d[i] = Math.max(d[i-2]+map[i], d[i-3]+map[i-1]+map[i]);
			
		}
		System.out.println(d[n]);
	}
}
