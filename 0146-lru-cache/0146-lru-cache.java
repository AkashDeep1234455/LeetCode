class Node {
    Node next, prev;
    int value, key;

    public Node(int key, int value) {
        this.value = value;
        this.key = key;
    }
}

class LRUCache {
    private Node head, tail;
    private HashMap<Integer, Node> map;
    private int capacity, count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if (count < capacity) {
                count++;
                addToHead(newNode);
            } else {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
                addToHead(newNode);
            }
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
