package p03_HashMapImpl;

public class MyEntry<K, V> {
	private final K _key;
	private V _value;
	private MyEntry<K, V> _next;

	public MyEntry(K key, V value, MyEntry<K, V> next) {
		_key = key;
		_value = value;
		_next = next;
	}
	
	public K getKey() {
		return _key;
	}
	public V getValue() {
		return _value;
	}
	
	public MyEntry<K, V> getNext() {
		return _next;
	}
	
	public void setValue(V value) {
		this._value = value;
	}
	
	public void setNext(MyEntry<K, V> next) {
		this._next = next;
	}
}