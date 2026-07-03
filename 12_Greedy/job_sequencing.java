import java.util.*;
class Job{
	int id , deadline , profit;
	Job(int id , int deadline , int profit){
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}
public class JobSequence{
	
	public static int[] jobScheduling(Job[] jobs, int n){
		Arrays.sort(jobs , (a,b) -> b.profit - a.profit);

		int maxdeadline = 0;

		for(Job job : jobs){
			maxdeadline = Math.max(maxdeadline , job.deadline);
		}

		int[] slots = new int[maxdeadline + 1];
		Arrays.fill(slots , -1);
		int jobcount = 0, totalprofit = 0;
		
		for(Job job : jobs){
			for(int j = job.deadline; j >= 1; j--){
				if(slots[j] == -1){
					slots[j] = job.deadline;
					jobcount++;
					totalprofit += job.profit;
					break;
				}
			}
		}
		return new int[]{jobcount , totalprofit};
	}
	
	public static void main(String[] args) {

        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        int[] ans = jobScheduling(jobs, jobs.length);

        System.out.println("Jobs Done: " + ans[0]);
        System.out.println("Profit: " + ans[1]);
    }
}
