import java.util.Scanner;

public class 백준5557 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		long[][] d = new long[n][21];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		d[0][arr[0]]++;
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<=20;j++) {
				if(d[i][j] != 0) {
					if(j+arr[i+1]<=20)
						d[i+1][j+arr[i+1]] += d[i][j];
					if(j-arr[i+1]>=0)
						d[i+1][j-arr[i+1]] += d[i][j];
				}
			}
		}
	
		System.out.println(d[n-2][arr[arr.length-1]]);
	}
}
