package p03_OnOffCollection;

import java.util.HashSet;

public class MyHashSet<T> extends HashSet<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(T e) {
		if(super.contains(e)) {
			super.remove(e);
			return false;
		} else {
			super.add(e);
		}
		return true;
	}
}
