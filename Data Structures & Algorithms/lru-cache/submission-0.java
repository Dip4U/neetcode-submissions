

class LRUCache {
    
    // DLL Node Blueprint
    private static class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Initialize dummy boundaries
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToTail(node); // Move accessed item to MRU position
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // Update value
            moveToTail(node);   // Move updated item to MRU position
        } else {
            // If capacity is reached, evict the LRU node
            if (cache.size() == capacity) {
                Node lruNode = head.next;
                removeNode(lruNode);
                cache.remove(lruNode.key);
            }
            
            // Add new node
            Node newNode = new Node(key, value);
            addNodeToTail(newNode);
            cache.put(key, newNode);
        }
    }
    
    // DLL Helper: Remove a node from its current position
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // DLL Helper: Add a node right before the dummy tail (MRU Position)
    private void addNodeToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
    
    // DLL Helper: Refresh an existing node's usage status
    private void moveToTail(Node node) {
        removeNode(node);
        addNodeToTail(node);
    }
}
