class Solution {
	
	public int findRoot(int n , int m) {
	
		int low = 1 , high = m;
		while(low <= high) {
			long val  = 1;
			int mid = low + (high - low) / 2;
			for(int i = 1; i <= n;i++) {
				val *= mid;
				if(val > m) break;
			}
			if(val == m) return mid;
			else if(val < m) low = mid + 1;
			else high = mid - 1;
		}
		return -1;
	}

}

public class nthRoot {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3, m = 27;

        // Find nth root
        System.out.println("Nth Root: " + sol.findRoot(n, m));
    }
}