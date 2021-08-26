import java.util.Scanner;

public class 백준2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int maxX=0;
		int maxY=0;
		int[] a = new int[6];
		for(int i=0;i<6;i++) {
			int dir = sc.nextInt();
			a[i] = sc.nextInt();
			if(dir== 3 || dir== 4) {
				maxX = Math.max(maxX, a[i]);
			}
			else {
				maxY = Math.max(maxY, a[i]);
			}
		}
		int tarX=0;
		int tarY=0;
		for(int i=0;i<=6;i++) {
			if((a[(i+5)%6] + a[(i+1)%6] == maxX) || (a[(i+5)%6] + a[(i+1)%6] == maxY )){
				if(tarX==0) tarX = a[i%6];
				else tarY =a[i%6];
			}
		}
		System.out.println((maxX*maxY-tarX*tarY)*n);
	}
}
