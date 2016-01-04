package p03_HashMapImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
	private final static float DEFAULT_LOAD_FACTOR = 0.75f;
	private final static int DEFAULT_CAPACITY = 16;

	private List<MyEntry<K, V>> _buckets;
	private int _arrCapacity;
	private int _entriesCount;

	public MyHashMap() {
		this(DEFAULT_CAPACITY);
	}

	public MyHashMap(int capacity) {
		_arrCapacity = capacity;
		_buckets = new ArrayList<>(_arrCapacity);
		init(_buckets, _arrCapacity);
	}

	private void init(List<MyEntry<K, V>> buckets, int capacity) {
		for (int i = 0; i < capacity; i++) {
			buckets.add(null);
		}
	}

	private int hash(Integer keyHash) {
		return Math.abs(keyHash % _arrCapacity);
	}

	private void resize(int newSize) {
		List<MyEntry<K, V>> oldBuckets = new ArrayList<>(_buckets);
		_arrCapacity = newSize;

		List<MyEntry<K, V>> newBuckets = new ArrayList<>(_arrCapacity);
		init(newBuckets, _arrCapacity);

		for (MyEntry<K, V> entry : oldBuckets) {
			if (entry != null) {
				rehash(entry, newBuckets);
			}
		}

	}

	private void rehash(MyEntry<K, V> newEntry, List<MyEntry<K, V>> newBuckets) {		
		int index;
		if (newEntry.getKey() == null) {
			index = 0;
		} else {
			index = hash(newEntry.getKey().hashCode());
		}
		
		MyEntry<K, V> tempEntry = newBuckets.get(index);
		newBuckets.set(index, new MyEntry<K, V>(newEntry.getKey(), newEntry.getValue(), tempEntry));
		_buckets = newBuckets;
	}

	private V putForNullKey(V value) {
		for (MyEntry<K, V> entry = _buckets.get(0); entry != null; entry = entry.getNext()) {
			if (entry.getKey() == null) {
				V oldValue = entry.getValue();
				entry.setValue(value);
				return oldValue;
			}
		}

		MyEntry<K, V> tempEntry = _buckets.get(0);
		_buckets.set(0, new MyEntry<K, V>(null, value, tempEntry));
		return null;
	}

	private V getForNullKey() {

		for (MyEntry<K, V> entry = _buckets.get(0); entry != null; entry = entry.getNext()) {
			if (entry.getKey() == null) {
				return entry.getValue();
			}
		}

		return null;
	}

	@Override
	public V put(K key, V value) {
		if (key == null) {
			V oldValue = putForNullKey(value);
			return oldValue;
		}

		int index = hash(key.hashCode());

		for (MyEntry<K, V> entry = _buckets.get(index); entry != null; entry = entry.getNext()) {
			if (key.equals(entry.getKey())) {

				V previousValue = entry.getValue();
				entry.setValue(value);
				return previousValue;
			}
		}

		MyEntry<K, V> tempEntry = _buckets.get(index);
		_buckets.set(index, new MyEntry<K, V>(key, value, tempEntry));

		double loadFactor = (double) ++_entriesCount / _arrCapacity;

		if (loadFactor >= DEFAULT_LOAD_FACTOR) {
			resize(_arrCapacity * 2);
		}

		return null;
	}

	@Override
	public V get(Object key) {
		if (key == null) {
			V value = getForNullKey();
			return value;
		}

		int index = hash(key.hashCode());

		for (MyEntry<K, V> entry = _buckets.get(index); entry != null; entry = entry.getNext()) {
			if (key.equals(entry.getKey())) {

				V value = entry.getValue();
				return value;
			}
		}

		return null;
	}

	@Override
	public boolean containsKey(Object key) {
		if (key == null) {
			V value = getForNullKey();
			return (value == null) ? false : true;
		}

		int index = hash(key.hashCode());

		for (MyEntry<K, V> entry = _buckets.get(index); entry != null; entry = entry.getNext()) {
			if (key.equals(entry.getKey())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public V remove(Object key) {

		int index;
		if (key == null) {
			index = 0;
		} else {
			index = hash(key.hashCode());
		}

		MyEntry<K, V> e = _buckets.get(index);
		MyEntry<K, V> previous = e;

		while (e != null) {
			if (key == null || (key != null && key.equals(e.getKey()))) {
				V value = e.getValue();
				if (previous == e) {
					MyEntry<K, V> next = e.getNext();
					_buckets.set(index, next);
				} else {
					previous.setNext(e.getNext());
					e.setNext(null);
				}
				_entriesCount--;
				return value;
			}
			previous = e;
			e = e.getNext();

		}

		return null;
	}

	public void display() {
		for (int i = 0; i < _arrCapacity; i++) {
			if (_buckets.get(i) == null) {
				System.out.println(i + ": " + _buckets.get(i));
			} else {

				System.out.print(i + ": ");
				for (MyEntry<K, V> entry = _buckets.get(i); entry != null; entry = entry.getNext()) {
					System.out.print("(key: " + entry.getKey() + ", value: " + entry.getValue() + ")");
					System.out.print(" -----> ");
				}
				System.out.println("null");
			}
		}
	}

	@Override
	public int size() {
		return _entriesCount;
	}

	@Override
	public boolean isEmpty() {
		return _entriesCount == 0;
	}

	@Override
	public boolean containsValue(Object value) {
		List<MyEntry<K, V>> temp = _buckets;

		for (int i = 0; i < temp.size(); i++) {
			for (MyEntry<K, V> e = temp.get(i); e != null; e = e.getNext()) {
				if (value.equals(e.getValue())) {
					return true;
				}
			}
		}

		return false;
	}
	@Override
	public void clear() {
		for(int i = 0; i < _arrCapacity; i++) {
			_buckets.set(i, null);
		}
		_entriesCount = 0;
	}

	//TODO
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		//this.clear();
		for(Map.Entry<? extends K, ? extends V> e: m.entrySet()) {
			this.put(e.getKey(), e.getValue());
		}

	}


	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}


}
