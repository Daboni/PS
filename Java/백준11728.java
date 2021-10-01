import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
	
	public class 백준11728 {
		public static void main(String[] args) throws NumberFormatException, IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
//			int[] result = new int[n+m];
			
			
			int[] arr1 = new int[n];
			st = new StringTokenizer(br.readLine()," ");
			
			for(int i=0;i<n;i++) arr1[i] = Integer.parseInt(st.nextToken());
			
			int[] arr2 = new int[m];
			st = new StringTokenizer(br.readLine()," ");

			for(int i=0;i<m;i++) arr2[i] = Integer.parseInt(st.nextToken());
			
			
			int i=0,j=0;
			
			
			
			for(int k=0;k<(n+m);k++) {
				
				if(i<n && j<m && arr1[i]<arr2[j]) {
//					result[k] = arr1[i];
					sb.append(arr1[i]+" ");
					i++;
					continue;
				}
				else if(i<n && j<m && arr1[i]>=arr2[j]){
//					result[k] = arr2[j];
					sb.append(arr2[j]+" ");
					j++;
					continue;
				}
				
				if(i>=n) {
					sb.append(arr2[j]+" ");
					j++;
					continue;
				}else if(j>=m){
					sb.append(arr1[i]+" ");
					i++;
					continue;
				}
			}
			System.out.println(sb.toString());
		}
	}