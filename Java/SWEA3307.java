import java.util.Arrays;
import java.util.Scanner;

public class SWEA3307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			int[] d = new int[n+1];
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			int size=0;
			for(int i=1;i<n;i++) {
				int tmp = Math.abs(Arrays.binarySearch(d,0,size, arr[i]))-1;
				d[tmp] = arr[i];
				if(tmp==size)size++;
			}
//			System.out.println(Arrays.toString(d));
			System.out.printf("#%d %d%n",tc,size);
		}
	}
}
