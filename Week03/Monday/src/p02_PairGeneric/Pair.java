package p02_PairGeneric;

public class Pair<F, S> {
	private final F firstObj;
	private final S secondObj;

	public Pair(F first, S second) {
		this.firstObj = first;
		this.secondObj = second;
	}

	public static <F, S> Pair<F, S> makePair(F first, S second) {
		return new Pair<F, S>(first, second);
	}

	public F getFirst() {
		return this.firstObj;
	}

	public S getSecond() {
		return this.secondObj;
	}

	@Override
	public String toString() {
		String newStr = ("First Obj is " + this.firstObj + '\n' + "Second Obj is " + this.secondObj);
		return newStr;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Pair)) {
			return false;
		}
		
		@SuppressWarnings("unchecked")
		Pair<F, S> other = (Pair<F, S>) obj;


		if (this.firstObj == null && other.firstObj != null) {
			return false;
			
		} else if (this.secondObj == null && other.secondObj != null) {
			return false;
			
		} else if (this.firstObj == null && other.firstObj == null) {
			if (this.secondObj == null && other.secondObj == null) {
				return true;
				
			} else {
				return this.secondObj.equals(other.secondObj);
				
			}
			
		} else if (this.secondObj == null && other.secondObj == null) {
			return this.firstObj.equals(other.firstObj);
			
		}
		
		if (this.firstObj.equals(other.firstObj) && this.secondObj.equals(other.secondObj)) {
			return true;
		}

		return false;
	}
}

