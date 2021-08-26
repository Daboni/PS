import java.util.Arrays;
import java.util.Scanner;

public class SWEA최적경로 {
	static class Pair{
		int x,y;
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static int n;
	static Pair[] a;
	
	static int ans;
	static boolean np(int[] numbers) {
		
		int N = numbers.length;
		
		int i=N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		if(i==0) return false;
		
		int j = N-1;
		while(numbers[i-1]>=numbers[j]) --j;
		
		swap(numbers,i-1,j);
		
		int k = N-1;
		while(i<k) swap(numbers,i++,k--);
		return true;
		
		
	}
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			n = sc.nextInt();
			Pair starts = new Pair(sc.nextInt(),sc.nextInt());
			Pair dest = new Pair(sc.nextInt(),sc.nextInt());
			a = new Pair[n];
			
			for(int i=0;i<n;i++) {
				a[i] = new Pair(sc.nextInt(),sc.nextInt());
			}
			int[] d = new int[n];
			for(int i=0;i<n;i++) {
				d[i] = i;
			}
			ans = 987654321;
			do {
				int sum=0;
				Pair start = starts;
				for(int i=0;i<n;i++) {
					sum += ((Math.abs(start.x-a[d[i]].x)+Math.abs(start.y-a[d[i]].y)));
					start = a[d[i]];
					if(sum>ans) break;
				}
				sum += ((Math.abs(start.x-dest.x)+Math.abs(start.y-dest.y)));
				
				ans = Math.min(ans, sum);
				
				
			}while(np(d));
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
