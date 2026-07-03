import java.util.*;
public class MaxPlatforms{
	public static int countPlatforms(int n , int[] arr, int[] dep){
		int platforms = 1 , result = 1;
		int i = 1, j = 0;
		Arrays.sort(arr);
		Arrays.sort(dep);
		while(i < n && j < n){
			if(arr[i] <= dep[j]){
				platforms++;
				i++;
			}else{
				platforms--;
				j++;
			}
			result = Math.max(result , platforms);
		}
		return result;
	}
	
	public static void main(String[] args) {

        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        int n = arr.length;

        int result = countPlatforms(n , arr , dep);
	System.out.println("Max Platforms required are : " + result);
    	}
}