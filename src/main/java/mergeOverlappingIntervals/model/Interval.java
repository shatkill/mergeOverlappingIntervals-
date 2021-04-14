package mergeOverlappingIntervals.model;

public class Interval implements Comparable<Interval>{
	
	long begin, end;

	public Interval(long begin, long end) {
		this.begin = begin;
		this.end = end;
	}

	public long getBegin() {
		return begin;
	}

	public void setBegin(long begin) {
		this.begin = begin;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "[" + begin + " ," + end + "]";
	}

	public int compareTo(Interval interval) {
		if(this.getBegin() > interval.getBegin()) {
			return 1;
		} else if(this.getBegin() < interval.getBegin()) {
			return -1;
		} else {
			return 0;
		}
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (begin != other.begin)
			return false;
		if (end != other.end)
			return false;
		return true;
	}
	
}
