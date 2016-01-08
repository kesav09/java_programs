package hashmap;
//put
//get
//remove
//

public class CustomHashMap<K,V>{
	Entry<K,V>[] table;
	int size;
	public static final int tableSize = 10;
	
	public CustomHashMap(){
		this(tableSize);
	}
	
	public CustomHashMap(int size){
		table = new Entry[size];
	}
	
	public void put(K key, V value){
		int hash = key.hashCode();
		int bucket = getBucket(hash);
		Entry<K,V> newEntry = new Entry<K,V>(key,value,hash);
		newEntry.next = table[bucket];
		table[bucket] = newEntry;
		size++;
	}
	
	public V get(K key){
		int hash = key.hashCode();
		int bucket = getBucket(hash);
		
		Entry<K,V> entry = table[bucket];
		while(entry!=null){
			if(entry.hash == hash && entry.key.equals(key)){
				return entry.value;
			}
			entry = entry.next;
		}
		return null;
	}
	
	public int getBucket(int hash){
		return (hash % tableSize);
	}

	public class Entry<K,V>{
		private K key;
		private V value;
		private Entry<K,V> next;
		private int hash;
		
		public Entry(K key, V value, int hash){
			this.key = key;
			this.value = value;
			this.hash = hash;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
		public Entry<K, V> getNext() {
			return next;
		}

		public int getHash() {
			return hash;
		}
	}
}