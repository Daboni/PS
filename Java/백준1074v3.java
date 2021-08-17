import java.util.Scanner;

public class 백준1074v3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int size = (1<<n);
		int cnt=0;
		while(n-->0) {
			if(r == 0 && c ==0) break;
			if(size == 2) {
				cnt+= r*2 + c; 
				break;
			}
			cnt += (r/(size/2)*((size/2)*(size/2))*2 + c/(size/2)*(size/2)*(size/2));
			
			r%=(size/2);
			c%=(size/2);
			size/=2;
		}
		System.out.println(cnt);
	}
}
