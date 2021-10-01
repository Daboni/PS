import java.util.Scanner;

public class 백준1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] d = new int[3];
		int[] c = new int[3];
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<3;j++) {
				if(i==0) {
					c[j] = sc.nextInt();
					continue;
				}
				d[j] = Math.min(c[(j+1)%3], c[(j+2)%3]) + sc.nextInt();
			}
			for(int j=0;j<3;j++) {
				if(i==0) break;
				c[j] = d[j];
			}
		}
		int min = 123456789;
		for(int i=0;i<3;i++) {
			min = Math.min(min, d[i]);
		}
		System.out.println(min);
	}
}
