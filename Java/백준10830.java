import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준10830 {
	public static long mod = 1000;
	public static int n;
	public static long b;
	
	 public static void main(String[] args) throws Exception{
		 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String[] s = br.readLine().split(" ");

		 n = Integer.parseInt(s[0]);
		 b = Long.parseLong(s[1]);
		 
		 long[][] matrix = new long[n][n];
		 for(int i=0;i<n;i++) {
			 s = br.readLine().split(" ");
			 for(int j=0;j<n;j++) {
				 matrix[i][j] = Integer.parseInt(s[j]);
			 }
		 }
		long[][] ans = pow(matrix,b);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	 public static long[][] pow(long[][] mat, long m) {
		 if(m==1) {
			 return mat;
		}
		 
		 long[][] tmp = pow(mat,m/2);
		 
		 if(m%2==1) {			 
			 return mul(mul(tmp,tmp),mat);
		 }
		 else return mul(tmp,tmp);
	 }
	 public static long[][] mul(long[][] mat1, long[][] mat2){
		 long[][] newMat = new long[n][n];
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<n;j++) {
				 long t =0;
				 for(int k=0;k<n;k++) {
					 t = (t%mod + mat1[i][k]*mat2[k][j]%mod)%mod;
				 }
				 newMat[i][j] = t;
			 }
		 }
		 return newMat;
	 }
}
