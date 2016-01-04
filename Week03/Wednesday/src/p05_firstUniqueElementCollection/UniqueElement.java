package p05_firstUniqueElementCollection;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class UniqueElement {
	
	public static<T> T findFirstUnique(Collection<T> collection) {
	
		Map<T, Integer> map = new LinkedHashMap<>();
		
		for(T elem: collection) {
			if(map.keySet().contains(elem)) {
				map.put(elem, map.get(elem) + 1);
			} else {
				map.put(elem, 1);
			}
		}
		
		for(Map.Entry<T, Integer> elem: map.entrySet()) {
			if(elem.getValue() == 1) {
				return elem.getKey();
			}
		}
		
		throw new NoSuchElementException("No unique elements!");
	}

}
