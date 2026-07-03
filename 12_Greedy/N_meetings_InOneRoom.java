import java.util.*;
class Meeting {
	int start , end , index;
	Meeting(int start , int end , int index){
		this.start = start;
		this.end = end;
		this.index = index;
	}
}
public class nMeetingsInaRoom {
	public static List<Integer> maxMeetings(int[] start , int[] end , int n) {
		List<Meeting> meetings = new ArrayList<>();
		for(int i = 0;i < n;i++){
			meetings.add(new Meeting(start[i] , end[i] , i + 1));
		}
		
		meetings.sort((a,b) -> {
			if(a.end == b.end) 
				return a.index - b.index;
			return a.end - b.end;
		});
		
		List<Integer> ans = new ArrayList<>();
		
		ans.add(meetings.get(0).index);
		int lastEnd = meetings.get(0).end;

		for(int i = 1;i < n;i++) {
			if(meetings.get(i).start > lastEnd) {
				ans.add(meetings.get(i).index);
				lastEnd = meetings.get(i).end;
			}
		}
		
		return ans;
	}
		
	public static void main(String[] args) {
        	int[] start = {1, 3, 0, 5, 8, 5};
        	int[] end = {2, 4, 5, 7, 9, 9};

        	List<Integer> result = maxMeetings(start, end, start.length);

       		System.out.println(result);
    	}
}