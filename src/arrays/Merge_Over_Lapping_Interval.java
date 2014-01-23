package arrays;
 
import java.util.*;
 
/*
 * Given a collection of intervals, merge all overlapping intervals. For example, Given [1,3],[2,6],[8,10],[15,18], 
 * return [1,6],[8,10],[15,18].
 */
public class Merge_Over_Lapping_Interval {
	
	public static void main(String[] args){
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		ArrayList<Interval> result = merge((ArrayList<Interval>) intervals);
		for(Interval i: result){
			System.out.println(i.toString());
		}
	}
	
	// An interval has start time and end time
	private static class Interval{
	    int start;
	    int end;
	    
	    public Interval(int start, int end){
	    	this.start = start;
	    	this.end = end;
	    }

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
	};
    
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size() == 0)
            return intervals;
        if(intervals.size() == 1)
            return intervals;
        
        Comparator<Interval> intervalComparator = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
        };
        
        Collections.sort(intervals, intervalComparator);
        
        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start <= end){
                end = Math.max(current.end, end);
            }else{
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
            
        }
        
        result.add(new Interval(start, end));
        
        return result;
        
    }
}