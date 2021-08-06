import java.util.Scanner;

public class 백준1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {

			int s = sc.nextInt();
			int num = sc.nextInt();

			if (s == 1) {
				for (int j = num; j <= n; j += num) {
					a[j] = a[j] ^ 1;
				}
			} else {
				for (int k = 1; k <= Math.min(num, n-num+1); k++) {
					if (num - k == 0) {
						for (int j = 1; j < num + k; j++)
							a[j] = a[j] ^ 1;
						break;
					}
					else if(num+k>n) {
						for (int j = n; j > num - k; j--)
							a[j] = a[j] ^ 1;
						break;
					
					}
					else if (a[num - k] != a[num + k]) {
						for (int j = num - k + 1; j < num + k; j++)
							a[j] = a[j] ^ 1;
						break;
					}
				}

			}
		}
		for(int i=1;i<a.length;i++) {
			if(i != 1 && i%20==1) {
				System.out.println();
				System.out.print(a[i]+ " ");
				
			}
			else System.out.print(a[i]+" ");
		}
	}
}
