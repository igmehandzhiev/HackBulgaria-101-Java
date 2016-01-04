package p06_duplicateInSets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesInSets {
	
	public static<T> Set<T> findDuplicates (List<Set<T>> allSets) {
		Set<T> result = new HashSet<>();
		
		for(Set<T> set: allSets) {
			result.addAll(set);
		}
		
		for(int i = 0; i < allSets.size(); i++) {
			result.retainAll(allSets.get(i));
		}
		
		return result;
	}
}