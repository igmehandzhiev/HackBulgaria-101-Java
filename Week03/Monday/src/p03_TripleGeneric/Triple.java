package p03_TripleGeneric;

//TODO

final public class Triple<F, S, L> {
	private final F firstObj;
	private final S secondObj;
	private final L lastObj;

	public Triple(F first, S second, L last) {
		this.firstObj = first;
		this.secondObj = second;
		this.lastObj = last;
	}

	public static <F, S, L> Triple<F, S, L> makeTriple(F first, S second, L last) {
		return new Triple<F, S, L>(first, second, last);
	}

	public F getFirst() {
		return this.firstObj;
	}

	public S getSecond() {
		return this.secondObj;
	}
	
	public L getLast() {
		return this.lastObj;
	}

	@Override
	public String toString() {
		String newStr = ("First Obj is " + this.firstObj + '\n' + "Second Obj is " + this.secondObj  + '\n' + "Third Obj is " + this.lastObj);
		return newStr;
	}

}
