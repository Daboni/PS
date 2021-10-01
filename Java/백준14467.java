import java.util.Scanner;

public class 백준14467 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt=0;
		int[] dir = new int[11];
		
		for(int i=0;i<11;i++) {
			dir[i] = -1;
		}
		
		for(int i=0;i<n;i++) {
			
			int num = sc.nextInt();
			int d = sc.nextInt();
			
			if(dir[num]==-1)
				dir[num] = d;
			
			else if((dir[num]^d) == 1) {
				cnt++;
				dir[num] = d;
			}
			
		}
		System.out.println(cnt);
	}
}
