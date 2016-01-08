package hashmap;


public class HashMapDesign<K, V> {
	private static final float EPSILON = 0.01f;
	private Entry<K, V>[] data;
	private final float LOAD_FACTOR;
	// Maintains the current fill
	int size = 0;
	private static final int DEFAULT_SIZE = 10;
	int total_size = 0;

	/**
	 * Default Constructor
	 */
	public HashMapDesign() {
		this(DEFAULT_SIZE);
	}

	public HashMapDesign(int size) {
		this(0.7f, size);
	}

	public HashMapDesign(final float loadFactor, int size) {
		data = new Entry[size];
		LOAD_FACTOR = loadFactor;
		total_size = size;
	}

	/**
	 * Put values into hashmap using hashcode of the key
	 * 
	 * NUll key is not allowed This function overrides the data in case a value
	 * is already present at the key
	 * 
	 * This can be modified to handle collisions using Chaining
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		if (key == null)
			throw new NullPointerException("null key");
		if (isFull()) {
			// resizing of Entry array
			resizeMap(data);
		}
		int idx = getIndex(key.hashCode()); // Override values.
		data[idx] = new Entry(key, value);
		size++;
	}

	/**
	 * get Value for given key using hashing
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("map empty");

		if (key == null)
			throw new NullPointerException("null key");

		int idx = getIndex(key.hashCode());

		if (idx >= data.length)
			return null;

		if (data[idx] != null)
			return data[idx].getValue();

		return null;
	}

	/**
	 * Remove given key in the hashMap
	 * 
	 * @param key
	 */
	public void remove(K key) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("map empty");

		if (key == null)
			throw new NullPointerException("null key");

	}

	/**
	 * Check if hashmap is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Check if threshold has reached
	 * 
	 * @return
	 */
	private boolean isFull() {
		return ((size / total_size) - LOAD_FACTOR) > EPSILON;
	}

	/**
	 * Resize map
	 * 
	 * @param data
	 */
	private void resizeMap(Entry<K, V>[] data) {
		Entry<K, V>[] resizedData = new Entry[data.length * 2]; // double the
		// length
		total_size = data.length * 2;
		// regenerate hash for each key?
		for (int i = 0; i < data.length; i++) {
			int idx = getIndex(data[i].getKey().hashCode());
			resizedData[idx] = new Entry(data[i].getKey(), data[i].getValue());
		}
		data = resizedData;
	}

	private int getIndex(int keyHash) {
		// Multiply with a large prime number to generate max range of distinct
		// keys
		return (keyHash * 31) % total_size;
	}
}

/**
 * Entry building block for HashMap
 * @param <K>
 * @param <V>
 */
class Entry<K, V> {
	private final K key;
	private V value;

	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}
