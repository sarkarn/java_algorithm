package algo.nns;

import java.util.HashMap;

public class LRUCache1 {
	
	
	public static void main(String args[]) {
		
		LRUCache1 cache1 = new LRUCache1(6);
		cache1.set(1, 10);
		cache1.set(2, 20);
		cache1.set(3, 30);
		cache1.set(4, 40);
		cache1.set(1, 15);
		cache1.set(5, 50);
		cache1.set(6, 60);
		
		int val = cache1.get(3);
		System.out.println(val);
		
		cache1.set(1, 17);
		val = cache1.get(1);
		System.out.println(val);
		
	}
	
	
	int currentSize;
	int capacity;
	CacheNode head;
	CacheNode tail;
	
	HashMap<Integer,CacheNode> map = new HashMap();
	
	public LRUCache1(int capacity) {
		this.capacity = capacity;
		head = new CacheNode();
		tail = new CacheNode();
		
		head.next = tail;
		tail.previous = head;
	}
	
	
	public int get(int key) {
		
		CacheNode node = map.get(key);
		//Empty Cache
		if(node == null) {
			return - 1;
		}
		
		delete(node);
		add(node);
		
		return node.value;
		
	}
	
	public void set(int key, int value) {
		
		//check this already exists
		if(map.containsKey(key)) {
			CacheNode node = map.get(key);
			delete(node);
			node.value = value;
			add(node);
		}else {
			CacheNode node = new CacheNode(key, value);
			add(node);
			map.put(key, node);
			currentSize++;
		}
		
		if(currentSize > capacity) {
			CacheNode delNode = tail.previous;
			delete(delNode);
			map.remove(delNode.key);
			currentSize--;
			
		}
		
	}
	
	private void add(CacheNode node) {
		CacheNode next = head.next;
		next.previous = node;
		node.next = next;
		
		node.previous = head;
		head.next = node;
		
		
	}
	
	private void delete(CacheNode node) {
		
		CacheNode previous = node.previous;
		CacheNode next = node.next;
		
		previous.next = next;
		next.previous = previous;
		
	}
	
	
	

}


class CacheNode {
	
	int key; 
	int value;
	CacheNode previous, next;
	
	public CacheNode( int key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public CacheNode() {
		this(-1,-1);
	}
	
	
}