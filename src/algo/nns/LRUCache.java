package algo.nns;

import java.util.HashMap;

public class LRUCache {
  int size, capacity;
  HashMap<Integer,Node> nodeMap = new HashMap<Integer, Node>();
  Node head, tail;
  
  public LRUCache(int capacity) {
	  this.capacity = capacity;
	  head = new Node();
      tail = new Node();
      head.next = tail;
      tail.previous = head;
  }
  
  public int get(int key) {
      Node n = nodeMap.get(key);
      if(null==n){
          return -1;
      }
      update(n);
      return n.value;
  }
  
  public void set(int key, int value) {
      Node n = nodeMap.get(key);
      if(null==n){
          n = new Node(key, value);
          nodeMap.put(key, n);
          add(n);
          ++size;
      }
      else{
    	  n = new Node(key, value);
          update(n);
      }
      if(size>capacity){
          Node toDel = tail.previous;
          deleteNode(toDel);
          nodeMap.remove(toDel.key);
          --size;
      }
  }
  
  private void update(Node node) {
	  deleteNode(node);
      add(node);
  }
  
  private void add(Node node){
	  
//	  //Always add in the top
      Node after = head.next;
      head.next = node;     
      node.previous = head;
      node.next = after;
      after.previous = node;
  }
  
  private void deleteNode(Node n) {
	  
	  //deleting other node
	  Node before = n.previous, 
	  after = n.next;
      before.next = after;
      after.previous = before;
  }
  
	
}

class Node {
	int key, value;
	Node previous;
	Node next;
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

	Node() {
		this(0, 0);
	}
}
